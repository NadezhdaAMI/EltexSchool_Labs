package com.company;

import java.util.UUID;

public class Credentials {

    UUID IDClient = UUID.randomUUID();
    String Surname;
    String Name;
    String MiddleName;
    String Email;

//    public Credentials(UUID IDClient) {
//        this.IDClient = IDClient;
//    }
//


    @Override
    public String toString() {
        return "Данные клиента: " + IDClient + ", " + Surname + ", "+ Name + ", "+ MiddleName + ", "+ Email;
    }
}
