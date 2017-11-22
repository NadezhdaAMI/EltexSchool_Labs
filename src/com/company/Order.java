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

    private final long TimeWaitingONE = 100; // время обработки одного товара в корзине

    private long dateCreation;

    public static volatile boolean isAwaiting = false;
    public static volatile boolean isProcessed = false;
//    public boolean setIsAwaiting;

    public boolean getisAwaiting() {
        return isAwaiting;
    }

    public boolean getisProcessed() {
        return isProcessed;
    }

    public static void setIsAwaiting(boolean isAwaiting) {
        Order.isAwaiting = isAwaiting;
    }

    public static void setIsProcessed(boolean isProcessed) {
        Order.isProcessed = isProcessed;
    }

    public Order(ShoppingCart cart, Credentials cred) {
        this.cart = cart;
        this.cred = cred;
        this.dateCreation = System.currentTimeMillis();
        setTimeCreation(this.dateCreation);
        this.setTimeWaiting(TimeWaitingONE*(cart.shopCartSize()));
        this.IDOrder = UUID.randomUUID();
        isAwaiting = true;
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

    public ShoppingCart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return " " + getIDOrder() + ", " + cred.toString() + getCart();
    }
}
