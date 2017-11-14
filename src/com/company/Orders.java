package com.company;

import java.sql.Time;
import java.util.*;

public class Orders<T> { // orders это объединение данных клиента и корзины

    UUID IDOrder;

    private List<T> ordersAll = new ArrayList<>();

    public long TimeCreation;
    public long TimeWaiting;


    private final long TimeWaitingT = 3000; // время обработки одного товара в корзине

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

    public void add(T o){
        ordersAll.add(o);
    }

    public void checkout(Credentials cr, ShoppingCart sh){
        T order = (T) new Order(sh, cr);
        ordersAll.add(order);

//        super.getOrder().add(cr.toString());
//        super.getOrder().add(sh.toString());
//        ordersAll.add(super.getOrder());
//        super.setTimeCreation(System.currentTimeMillis());
    }

    public UUID getIDOrder() {
        IDOrder = UUID.randomUUID();
        return IDOrder;
    }

    public TreeMap<UUID, Orders> testOrders(TreeMap<UUID, Orders> treeMap){
        TreeMap<UUID, Orders> treeMapTest = new TreeMap<>();
        for (Map.Entry<UUID, Orders> item: treeMap.entrySet())
        {

            item.getValue().setTimeWaiting(TimeWaitingT*item.getValue().ordersAll.size());
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
}
