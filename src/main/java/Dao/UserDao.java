package Dao;

import model.User;
import org.bson.Document;

import java.util.List;

public class UserDao extends DefaultDao {

    public static List<User> readAll() {
        return readAll(User.class);
    }

    public User readById(String id) {
        final Document filter = new Document();
        filter.append("id", id);
        return readByFilter(User.class, filter).get(0);
    }


    public void deleteById(String id) {
        deleteDataById(id,User.class);
    }




}
