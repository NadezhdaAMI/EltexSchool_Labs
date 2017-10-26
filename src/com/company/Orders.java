package com.company;

import java.sql.Time;
import java.util.*;

public class Orders extends Order {

    UUID IDOrder;

    private List<Object> ordersAll = new ArrayList<>();

    private Date TimeCreation;
    long TimeWaiting = 1500000;

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

    public long getTimeCreation(){
        long currentTime = System.currentTimeMillis();
        return currentTime;
    }

    public UUID getIDOrder() {
        IDOrder = UUID.randomUUID();
        return IDOrder;
    }

    public TreeMap<UUID, Orders> testOrders(TreeMap<UUID, Orders> treeMap){
        System.out.println("Проверка статуса заказов...");
        TreeMap<UUID, Orders> treeMap2 = new TreeMap<>();
        long t = System.currentTimeMillis();
        for (Map.Entry<UUID, Orders> item: treeMap.entrySet()){
            long timeObject = item.getValue().getTimeCreation();
            if ((t - timeObject) > TimeWaiting){
                System.out.println("Заказ обработан!");
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
        return "***"+ ordersAll;
    }
}
