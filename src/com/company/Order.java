package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

    private ShoppingCart cart;

    private Credentials cred;

    private UUID IDOrder;

    private long TimeCreation;
    private long TimeWaiting;

    private final long TimeWaitingONE = 3000; // время обработки одного товара в корзине

    private long dateCreation;

    public Order(ShoppingCart cart, Credentials cred) {
        this.cart = cart;
        this.cred = cred;
        this.dateCreation = System.currentTimeMillis();
        setTimeCreation(this.dateCreation);
        this.setTimeWaiting(TimeWaitingONE*(cart.shopCartSize()));
        this.IDOrder = UUID.randomUUID();
    }

    public void setTimeWaiting(long timeWaiting) {
        TimeWaiting = timeWaiting;
    }

    public long getTimeWaiting() {
        return TimeWaiting;
    }

    public void setTimeCreation(long timeCreation) {
        TimeCreation = timeCreation;
    }

    public long getTimeCreation() {
        return TimeCreation;
    }

    public UUID getIDOrder() {
        return IDOrder;
    }

    //    public Date getDateCreation() {
//        dateCreation = new Date();
//        return dateCreation;
//    }


    public Credentials getCred() {
        return cred;
    }

    public ShoppingCart getCart() {
        return cart;
    }



//    @Override
//    public String toString() {
//        return " " + cred.toString() + cart.toString();
//    }
}
