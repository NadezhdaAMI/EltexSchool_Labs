package com.company;

import java.util.ArrayList;
import java.util.UUID;

abstract class Electronics implements ICrudAction {
    UUID IDelectronics;
    String Name;
    int Price;
    String NameCompany;
    String Model;
    String NameOperSystem;
    static int CountElectronics;

    static ArrayList<Electronics> Devices = new ArrayList<>();

    public static final int getCountElectronics(){
        return CountElectronics;
    }


}