package com.company;

import java.sql.Time;
import java.util.*;

public class Orders<T> { // orders это объединение данных клиента и корзины

    private List<T> ordersAll = new ArrayList<>(); //

    public int size(){
        return ordersAll.size();
    }

    public T returnOrderONE(int i){
        return ordersAll.get(i);
    }

    public void checkout(Credentials cr, ShoppingCart sh){
        T order = (T) new Order(sh, cr);
        ordersAll.add(order);
    }

    public void showOrdersAll(){
        for (Object k: ordersAll) {
        System.out.println(k.toString());
        }
    }

    @Override
    public String toString() {
        return " "+ ordersAll;
    }
}
