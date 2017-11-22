package com.company;

import java.util.Random;
import java.util.UUID;

public class Credentials {

    UUID IDClient;
    String Surname;
    String Name;
    String MiddleName;
    String Email;

    public UUID getIDClient() {
        return IDClient;
    }

    @Override
    public String toString() {
        return /*IDClient + ", " + */ Surname + ", "+ Name + ", "+ MiddleName + ", "+ Email;
    }
}
