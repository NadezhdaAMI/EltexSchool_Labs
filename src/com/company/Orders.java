package com.company;

import java.sql.Time;
import java.util.*;

public class Orders extends Order { // orders это объединение данных клиента и корзины

    UUID IDOrder;

    private List<Object> ordersAll = new ArrayList<>();


    private final long TimeWaiting = 3000; // время обработки одного товара в корзине

    public void showOrdersAll(){
        for (Object k: ordersAll) {
            System.out.println(k.toString());
        }
    }

    public int size(){
        return ordersAll.size();
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
        super.setTimeCreation(System.currentTimeMillis());
    }

    public UUID getIDOrder() {
        IDOrder = UUID.randomUUID();
        return IDOrder;
    }

    public TreeMap<UUID, Orders> testOrders(TreeMap<UUID, Orders> treeMap){
        TreeMap<UUID, Orders> treeMapTest = new TreeMap<>();
        for (Map.Entry<UUID, Orders> item: treeMap.entrySet()){
            item.getValue().setTimeWaiting(TimeWaiting*item.getValue().getOrder().size());
            long timeObject = item.getValue().getTimeCreation();
            long t = System.currentTimeMillis();
            if ((t - timeObject) > item.getValue().getTimeWaiting()){
                System.out.println("Заказ обработан! так как с момента создания заказа прошло " + (t - timeObject)/1000 + "sec," + " заказ: " + item.getValue().getOrdersAll().toString());
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
}
