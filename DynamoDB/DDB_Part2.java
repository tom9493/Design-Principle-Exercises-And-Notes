import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

import java.util.*;

public class DDB_Part2 {
    public static void main(String[] args) throws Exception {
          final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-1").build();
          final DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
         final Table table = dynamoDB.getTable("Follows");
         final Index index = table.getIndex("secondary");
         final String partKey = "follower_handle";
         final String sortKey = "followee_handle";

        List<String> followers = new ArrayList<>();

        Map<String, String> attrNames = new HashMap<>();
        attrNames.put("#sort", sortKey);

        Map<String, AttributeValue> attrValues = new HashMap<>();
        attrValues.put(":followee_handle", new AttributeValue().withS("@Sky"));

        QueryRequest queryRequest = new QueryRequest()
                .withTableName(table.getTableName())
                .withIndexName(index.getIndexName())
                .withKeyConditionExpression("#sort = :followee_handle")
                .withExpressionAttributeNames(attrNames)
                .withExpressionAttributeValues(attrValues);
        //.withLimit(pageSize);

        QueryResult queryResult = amazonDynamoDB.query(queryRequest);
        List<Map<String, AttributeValue>> items = queryResult.getItems();
        if (items != null) {
            for (Map<String, AttributeValue> item : items) {
                String follower = item.get("follower_handle").getS();
                followers.add(follower);
            }
        }
        System.out.println("Followers: " + followers);

        List<String> following  = new ArrayList<>();

        attrNames = new HashMap<>();
        attrNames.put("#part", partKey);

        attrValues = new HashMap<>();
        attrValues.put(":follower_handle", new AttributeValue().withS("@Tom"));

        queryRequest = new QueryRequest()
                .withTableName(table.getTableName())
                .withKeyConditionExpression("#part = :follower_handle")
                .withExpressionAttributeNames(attrNames)
                .withExpressionAttributeValues(attrValues);
        // .withLimit(pageSize);

        queryResult = amazonDynamoDB.query(queryRequest);
        items = queryResult.getItems();
        if (items != null) {
            for (Map<String, AttributeValue> item : items) {
                String followee = item.get("followee_handle").getS();
                following.add(followee);
            }
        }
        System.out.println("following for Tom: " + following);
    }
}
