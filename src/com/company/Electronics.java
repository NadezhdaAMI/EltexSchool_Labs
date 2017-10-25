package com.company;

import java.util.UUID;

abstract class Electronics implements ICrudAction {
    UUID IDelectronics;
    String Name;
    int Price;
    String NameCompany;
    String Model;
    String NameOperSystem;
    static int CountElectronics;

    public Electronics(UUID ID) {

        IDelectronics = ID;
    }

    public static final int getCountElectronics(){
        return CountElectronics;
    }

}