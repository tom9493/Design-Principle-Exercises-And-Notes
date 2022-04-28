import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Long.parseLong;

public class DDB_Test {
    public static void main(String[] args) throws Exception {
          final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-1").build();
          final DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
         final Table table = dynamoDB.getTable("User");
         final String partitionKey = "user_alias";
         final String passwordKey = "password";
         final String firstKey = "firstname";
         final String lastKey = "lastname";
         final String imageKey = "imageURL";


//         final String partKey = "follower_handle";
//         final String sortKey = "followee_handle";
//
//          final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion("us-west-1").build();
//          final DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
//         final Table table = dynamoDB.getTable("Follows");

//        List<Status> feed = new ArrayList<>();
//
//        Map<String, String> attrNames = new HashMap<>();
//        attrNames.put("#part", partKey);
//
//        Map<String, AttributeValue> attrValues = new HashMap<>();
//        attrValues.put(":receiver_alias", new AttributeValue().withS("@Bear"));
//
//        QueryRequest queryRequest = new QueryRequest()
//                .withTableName(table.getTableName())
//                .withKeyConditionExpression("#part = :receiver_alias")
//                .withExpressionAttributeNames(attrNames)
//                .withExpressionAttributeValues(attrValues);
//
//
//        QueryResult queryResult = amazonDynamoDB.query(queryRequest);
//        List<Map<String, AttributeValue>> items = queryResult.getItems();
//        if (items != null) {
//            for (Map<String, AttributeValue> item : items) {
//                Status status = new Status(item.get("post").getS(), null, parseLong(item.get("time_stamp").getN()),
//                        item.get("urls").getSS(), item.get("mentions").getSS());
//                feed.add(status);
//            }
//        }
//        System.out.println(feed);

//        Item item = table.getItem(partKey, "@Tom", sortKey, "@Bear");
//        System.out.println("item != null: " + item != null);
//        Item item = table.getItem(partitionKey, "@tom");
//        System.out.println(item);
//        System.out.println("Item.getString: " + item.getString(passwordKey).equals("hart"));
//        else if (item.getString(passwordKey).equals("hart")) {
//            return new User(item.getString(firstKey), item.getString(lastKey), item.getString(partitionKey), item.getString(imageKey));
//        }
//        return null;

        System.out.println(hash("hellothere"));
    }

    public static String hash(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();

            for (byte b : resultByteArray) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
