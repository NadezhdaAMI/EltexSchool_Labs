package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private List<Object> order = new ArrayList<>();

    public long TimeCreation;
    public long TimeWaiting;

    public Date dateCreation;

    public List<Object> getOrder() {
        return order;
    }

    public void showOrder(){
        for (Object k: order) {
            System.out.println(k.toString());
        }
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

    public Date getDateCreation() {
        dateCreation = new Date();
        return dateCreation;
    }
}
