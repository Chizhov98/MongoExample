package Dao;

import model.User;
import org.bson.Document;

import java.util.List;

public class UserDao extends DefaultDao {

    public List<User> readAll() {
        return super.readAll(User.class);
    }

    public User readById(String id) {
        final Document filter = new Document();
        filter.append("id", id);
        return readByFilter(User.class,filter).get(0);
    }


}
