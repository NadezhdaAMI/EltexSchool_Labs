package com.company;

import java.sql.Time;
import java.util.*;

public class Orders extends Order { // orders это объединение данных клиента и корзины

    UUID IDOrder;

    private List<Object> ordersAll = new ArrayList<>();


    private long TimeWaiting = 15000;

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
        super.setTimeCreation(System.currentTimeMillis());
    }

    public UUID getIDOrder() {
        IDOrder = UUID.randomUUID();
        return IDOrder;
    }

    public TreeMap<UUID, Orders> testOrders(TreeMap<UUID, Orders> treeMap){
        TreeMap<UUID, Orders> treeMap2 = new TreeMap<>();
        for (Map.Entry<UUID, Orders> item: treeMap.entrySet()){
            long timeObject = item.getValue().getTimeCreation();
            long t = System.currentTimeMillis();
            if ((t - timeObject) > TimeWaiting){
                System.out.println("Заказ обработан! так как с момента создания заказа прошло " + (t - timeObject)/1000 + "sec," + " заказ: " + item.getValue().getOrdersAll().toString());
            }
            else {
//                System.out.println("Заказ еще в процессе обработки!");
                treeMap2.put(item.getKey(), item.getValue());
            }
        }
        return treeMap2;
      }

    @Override
    public String toString() {
        return " "+ ordersAll;
    }
}
