package Utilst;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoUtils {

    public static MongoDatabase connect(String databaseName) {
        return getMongoClient(null).getDatabase(databaseName);
    }

    public static MongoDatabase connect(String databaseName, MongoCredential credential) {
        return getMongoClient(credential).getDatabase(databaseName);
    }

    private static MongoClient mongoClient;

    private static MongoClient getMongoClient(MongoCredential credential) {
        if (mongoClient == null) {
            final MongoClientOptions.Builder options = MongoClientOptions.builder();
            mongoClient = credential == null ? new MongoClient("localhost", 27017) :
                    new MongoClient(new ServerAddress("localhost", 27017), credential, options.build());
        }

        return mongoClient;
    }

    public static <T>Document mapperFrom(T object) {
        Gson gson = new Gson();
        return Document.parse(gson.toJson(object));
    }


}
