package Dao;

import model.BankAccount;
import model.User;
import org.bson.Document;

import java.util.List;

public class BankAccountDao extends DefaultDao{
    public List<BankAccount> readAll() {
        return readAll(BankAccount.class);
    }

    public BankAccount readById(String id) {
        final Document filter = new Document();
        filter.append("id", id);
        return readByFilter(BankAccount.class,filter).get(0);
    }

}
