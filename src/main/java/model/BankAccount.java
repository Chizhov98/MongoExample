package model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class BankAccount {

    private String id;
    private String UserId;

    @Override
    public String toString() {
        id = UUID.randomUUID().toString();
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", UserId='" + UserId + '\'' +
                '}';
    }
}

