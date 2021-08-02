import Dao.DefaultDao;
import Dao.UserDao;
import Utilst.MongoUtils;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.User;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MongoDatabase database = MongoUtils.connect("hw26");
        User user1= new User("Artem","Chizhov", 23 ,"A-level","Kharkov");
        DefaultDao.insertOne(user1);

        System.out.println(UserDao.readAll().get(2).toString());
    }
}
