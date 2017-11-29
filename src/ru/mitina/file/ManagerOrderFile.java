package ru.mitina.file;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import ru.mitina.Main;
import ru.mitina.orders.Credentials;
import ru.mitina.orders.Order;
import ru.mitina.orders.Orders;
import ru.mitina.orders.ShoppingCart;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class ManagerOrderFile extends AManageOrder {  //для хранения заказов в виде двоичного файла.

    @Override
    public UUID readById() {
        return null;
    }

    @Override
    public void saveAll(TreeMap<UUID, Order> ordersLoc) {
        System.out.println("Сохранение заказов в файл... ");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("OrdersBin.bin"))) {
            for (Map.Entry<UUID, Order> item : ordersLoc.entrySet()) {
                objectOutputStream.writeObject(item.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Сериализация выполнена успешно!");
    }

    @Override
    public void readAll() throws IOException, ClassNotFoundException{
        System.out.println("Чтение заказов из файла... ");
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("OrdersBin.bin"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < Main.COUNTPEOPLE; i++) {
                Order ord = (Order) objectInputStream.readObject();
                System.out.println(ord.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Десериализация выполнена успешно!");
    }
}


