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
    public void delete(){
        IDClient = null;
        Surname = null;
        Name = null;
        MiddleName = null;
        Email = null;
    }


    @Override
    public String toString() {
        return "Данные клиента: " + IDClient + ", " + Surname;
//                + ", "+ Name + ", "+ MiddleName + ", "+ Email;
    }
}
