package model;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public final class User {
    private String id;
    private String firstName;
    private String lastName;
    private List<BankAccount> bankAccounts;
    private int age;
    private String companyName;
    private String city;

    public User(String firstName, String lastName, int age, String companyName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.companyName = companyName;
        this.city = city;
    }
}
