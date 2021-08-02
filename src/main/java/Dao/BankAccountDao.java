package Dao;

import model.BankAccount;
import model.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDao extends DefaultDao {
    public List<BankAccount> readAll() {
        return readAll(BankAccount.class);
    }

    public BankAccount readById(String id) {
        final Document filter = new Document();
        filter.append("id", id);
        return readByFilter(BankAccount.class, filter).get(0);
    }

    public void deleteById(String id) {
        deleteDataById(id, User.class);
    }

    public List<User> findUserWithAccounts(int minCounter) {
        List<User> users = new ArrayList<>();
        List<User> allUsers = readAll(User.class);
        for (User elem : allUsers) {
            if (elem.getBankAccountsId().size() >= minCounter) {
                users.add(elem);
            }
        }
        return users;
    }
}
