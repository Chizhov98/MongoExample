package model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public final class User {
    private String id;
    private String firstName;
    private String lastName;
    private List<String> bankAccountsId= new ArrayList<>();
    private int age;
    private String companyName;
    private String city;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankAccountsId=" + bankAccountsId +
                ", age=" + age +
                ", companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public User(String firstName, String lastName, int age, String companyName, String city) {
        id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.companyName = companyName;
        this.city = city;
    }
}
