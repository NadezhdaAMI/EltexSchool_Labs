package ru.mitina.items;

import java.util.UUID;

public abstract class Electronics implements ICrudAction {
    public UUID ID;
    String Name;
    int Price;
    String NameCompany;
    String Model;
    String NameOperSystem;
    static int CountElectronics;

    public Electronics(UUID ID) {

        this.ID = ID;
    }

    public static final int getCountElectronics(){
        return CountElectronics;
    }

    @Override
    public String toString() {
        return ID + ", " + Name + ", "+ Price + ", "+ Price + ", "
                + NameCompany + ", " + Model + ", "+ NameOperSystem;
    }


}