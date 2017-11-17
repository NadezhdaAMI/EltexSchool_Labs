package com.company;

import java.sql.Time;
import java.util.*;

public class Orders<T> { // orders это объединение данных клиента и корзины

    private List<T> ordersAll = new ArrayList<>();

    public void showOrdersAll(){
        for (Object k: ordersAll) {
            System.out.println(k.toString());
        }
    }

    public int size(){
        return ordersAll.size();
    }

    public List<T> getOrdersAll() {
        return ordersAll;
    }

    public T returnOrderONE(int i){
        return ordersAll.get(i);
    }

    public void checkout(Credentials cr, ShoppingCart sh){
        T order = (T) new Order(sh, cr);
        ordersAll.add(order);
    }

    public TreeMap<UUID, Order> testOrders(TreeMap<UUID, Order> treeMap){
        TreeMap<UUID, Order> treeMapTest = new TreeMap<>();
        for (Map.Entry<UUID, Order> item: treeMap.entrySet())
        {
            long timeObject = item.getValue().getTimeCreation();
            long t = System.currentTimeMillis();
            if ((t - timeObject) > item.getValue().getTimeWaiting()){
                System.out.println("Заказ обработан! так как с момента создания заказа прошло "
                        + (t - timeObject)/1000 + "sec," + " заказ: " + item.getValue().getIDOrder());
            }
            else {
//                System.out.println("Заказ еще в процессе обработки!");
                treeMapTest.put(item.getKey(), item.getValue());
            }
        }
        return treeMapTest;
      }

    @Override
    public String toString() {
        return " "+ ordersAll;
    }


//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
}
