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
        System.out.println("***Подробрее о заказе: ");
        ListIterator<Object> iterator = order.listIterator();
        while (iterator.hasNext())
//            if (order instanceof Electronics) {
//                System.out.println(iterator.next().toString());
//                System.out.println();
//            }
            System.out.println(iterator.next().toString());
    }

    public void checkout(Credentials cr, List<Electronics> sh){
        this.order = order;
        order.add(cr);
        order.add(sh);
    }

    public void testOrders(){

    }
}
