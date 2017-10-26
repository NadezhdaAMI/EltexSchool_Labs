package com.company;

import java.sql.Time;
import java.util.*;

public class Orders extends Order {

    UUID IDOrder;

    private List<Object> ordersAll = new ArrayList<>();

    private Date TimeCreation;
    long TimeWaiting = 10000;

    public void showOrdersAll(){
        for (Object k: ordersAll) {
            System.out.println(k.toString());
        }
    }

    public List<Object> getOrdersAll() {
        return ordersAll;
    }

    public void add(Order o){
        ordersAll.add(o);
    }

    public void checkout(Credentials cr, ShoppingCart sh){
        super.getOrder().add(cr.toString());
        super.getOrder().add(sh.toString());
        ordersAll.add(super.getOrder());
//        TimeCreation = getCurrentTime();
    }

    public Date getTimeCreation(){
        Date currentTime = new Date(System.currentTimeMillis());
        return currentTime;
    }

    public UUID getIDOrder() {
        IDOrder = UUID.randomUUID();
        return IDOrder;
    }

    public void testOrders(){
    }

    @Override
    public String toString() {
        return "***"+ ordersAll;
    }
}
