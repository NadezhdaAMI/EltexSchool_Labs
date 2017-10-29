package com.company;

import java.util.Random;
import java.util.UUID;

public class Credentials {

    UUID IDClient;
    String Surname;
    String Name;
    String MiddleName;
    String Email;

    @Override
    public String toString() {
        return IDClient + ", " + Surname + ", "+ Name + ", "+ MiddleName + ", "+ Email;
    }
}
