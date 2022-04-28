import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class FollowItems {
    final String passwordKey = "password";
    final String firstKey = "firstname";
    final String lastKey = "lastname";
    final String imageKey = "imageURL";
   // Table tableU = dynamomDB.getTable("User");

    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion("us-west-1")
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);
         Table tableF = dynamoDB.getTable("Follows");


        final String partKey = "follower_handle";
        final String sortKey = "followee_handle";


        int verbose = 0;

        List<String> handles = Arrays.asList("@Tom", "@Lizard", "@Sky", "@Bird1", "@Bird2", "@Bear", "@Wolf",
                "@NightSky", "@Flower", "@Cow", "@Dolphin", "@Rhino", "@Lion", "@Goose", "@Ox", "@Moose");
 //       List<String> names = new ArrayList<>();
//        for (int i = 0; i < handles.size(); ++i) {
//            names.add(handles.get(i).replace("@", ""));
//        }

        for (int i = 0; i < handles.size(); ++i) {
           // addUser(handles.get(i), names.get(i), names.get(i), "Profile");
            for (int j = 0; j < handles.size(); ++j) {
                if (i != j) {
                    PutItemOutcome outcome = tableF
                            .putItem(new Item().withPrimaryKey(partKey, handles.get(i), sortKey, handles.get(j)));
                }
            }
        }
    }


    public void addUser(String username, String hashedPassword, String firstName, String lastName, String imageURL) {
        Item item = new Item().withPrimaryKey("user_alias", username)
                .withString(passwordKey, hashedPassword)
                .withString(firstKey, firstName)
                .withString(lastKey, lastName)
                .withString(imageKey, imageURL);
        //tableU.putItem(item);
    }
    public String hash(String password) {
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

//
//        // Add 50 specified Items
//        for (int i = 0; i < 25; ++i) {
//            try {
//                System.out.println("Adding a new item...");
//                PutItemOutcome outcome = table
//                        .putItem(new Item().withPrimaryKey("follower_handle", "@FredFlinstone", "followee_handle", "@TomHart_"+i)
//                                .withString("follower_name", "Fred Flinstone")
//                                .withString("followee_name", "Tom Hart_"+i)
//                        );
//                System.out.println("Loop 1, i = " + i);
//                System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());
//
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//        sleep(10000); // Short sleep to prevent exception being thrown
//        for (int i = 0; i < 26; ++i) {
//            try {
//                System.out.println("Adding a new item...");
//                PutItemOutcome outcome = table
//                        .putItem(new Item().withPrimaryKey("follower_handle", "@JackJohnson_"+i, "followee_handle", "@BobRoss")
//                                .withString("follower_name", "Jack Johnson_"+i)
//                                .withString("followee_name", "Boss Ross")
//                        );
//                System.out.println("Loop 2, i = " + i);
//                System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());
//
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
//
//
//        // Get item from database and print it
//        GetItemSpec spec = new GetItemSpec().withPrimaryKey("follower_handle", "@JackJohnson_1", "followee_handle", "@BobRoss");
//
//        try {
//            System.out.println("Attempting to read the item...");
//            Item outcome = table.getItem(spec);
//            System.out.println("GetItem succeeded: " + outcome);
//
//        }
//        catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//
//        // Update item
//        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("follower_handle", "@JackJohnson_1", "followee_handle", "@BobRoss")
//                .withUpdateExpression("set follower_name = :a, followee_name = :b")
//                .withValueMap(new ValueMap()
//                .withString(":a", "not Jack Johnson").withString(":b", "not Bob Ross"))
//                .withReturnValues(ReturnValue.UPDATED_NEW);
//
//        try {
//            System.out.println("Updating the item...");
//            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
//            System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());
//
//        }
//        catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        // Delete Item
//        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
//                .withPrimaryKey(new PrimaryKey("follower_handle", "@JackJohnson_2", "followee_handle", "@BobRoss"));
//
//        try {
//            System.out.println("Attempting a conditional delete...");
//            table.deleteItem(deleteItemSpec);
//            System.out.println("DeleteItem succeeded");
//        }
//        catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }
//}
