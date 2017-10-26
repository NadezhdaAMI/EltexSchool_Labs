package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Order {



    private List<Object> order = new ArrayList<>();

    public List<Object> getOrder() {
        return order;
    }

    public void showOrder(){
        for (Object k: order) {
            System.out.println(k.toString());
        }
    }


}
