package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Orders extends Order {

    private List<Object> order = new ArrayList<>();

    // здесь будет класс коллекция заказ = корзина+фио;

    // время создания;

    // время ожидания;

    // показать все заказы

    public void showOrders(){

        for (int i = 0; i < order.size() ; i++) {
            System.out.println(order.get(i));

        }
    }

    public void checkout(Credentials cr, ShoppingCart sh){
        this.order = order;
        order.add(cr);
        order.add(sh);
    }

    public void testOrders(){

    }



}
