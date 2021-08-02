package Dao;

import Utilst.MongoUtils;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultDao {
    static MongoDatabase database = MongoUtils.connect("aLevel");

    public static MongoCollection<Document> getMongoCollection(String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection;
    }

    public static <T> void insertOne(T obj) {
        MongoCollection<Document> collection = getMongoCollection(obj.getClass().getSimpleName());
        collection.insertOne(MongoUtils.mapperFrom(obj));
    }

    public static <T> void insertList(List<T> obj) {
        MongoCollection<Document> collection = getMongoCollection(obj.getClass().getSimpleName());
        List<Document> documentList = obj.stream().map(MongoUtils::mapperFrom).collect(Collectors.toList());
        collection.insertMany(documentList);
    }

    public static <T> List<T> readAll(Class<T> type) {
        Gson gson = new Gson();
        MongoCollection<Document> collection = getMongoCollection(type.getSimpleName());
        return collection.find().map(x -> gson.fromJson(x.toJson(), type))
                .into(new ArrayList<>());
    }

    public static <T> List<T> readByFilter(Class<T> type, Document filter) {
        Gson gson = new Gson();
        MongoCollection<Document> collection = getMongoCollection(type.getSimpleName());
        return collection.find(filter).map(x -> gson.fromJson(x.toJson(), type))
                .into(new ArrayList<>());
    }

    public static <T> void updateObjectById(String id, T object) {
        Document filter = new Document();
        filter.append("id", id);

        Document newData = MongoUtils.mapperFrom(object);

        final Document updateObject = new Document();
        updateObject.append("$set", newData);

        MongoCollection<Document> collection = getMongoCollection(object.getClass().getSimpleName());

        collection.updateOne(filter, updateObject);
    }

    protected static <T> void deleteDataById(String id, Class<T> type) {
        final Document filter = new Document();
        filter.append("id", id);

        MongoCollection<Document> collection = getMongoCollection(type.getSimpleName());
        collection.deleteOne(filter);
    }
}
