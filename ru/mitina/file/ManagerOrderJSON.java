package ru.mitina.file;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.codehaus.jackson.map.ObjectMapper;
import ru.mitina.Main;
import ru.mitina.orders.Order;
import ru.mitina.orders.Orders;

import java.io.*;
import java.util.*;

public class ManagerOrderJSON extends AManageOrder {        //для хранения заказов в виде текстового файла в формате JSON

    private static final String FILENAME = "/home/nadezhda/EltexSchool/Java_labs/Laba5FINAL/fileJSONwithOrders.json";
    private static final String FILENAMETMP = "/home/nadezhda/EltexSchool/Java_labs/Laba5FINAL/fileJSONwithOrdersTmp.json";

    @Override
    public Order readById(UUID idOrder) {
        System.out.println("Поиск заказа по ID в файле .json: ");
        System.out.println("Ищем... " + idOrder);
        ObjectMapper objectMapper = new ObjectMapper();
        Order ord = null;
        try {
            TreeMap<UUID, Order> ordersLoc = (TreeMap<UUID, Order>)objectMapper.readValue(new File(FILENAME),
                    TreeMap.class);
            for (Map.Entry<UUID, Order> item : ordersLoc.entrySet()) {
                System.out.println(idOrder);
                System.out.println(item.getKey());

                if (idOrder.toString().equals(item.getKey())){
                    System.out.println("Заказ с данным ID найден!");
                    System.out.println("Id: " + item.getKey());
                }
            }
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Поиск заказа по ID в файле .json выполнен успешно!");
        return ord;
    }

    @Override
    public void saveById(UUID id, Order ord) {
        System.out.println("Cохранение нового заказа по ID в файле .json: ");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TreeMap<UUID, Order> ordersLoc = objectMapper.readValue(new File(FILENAME), TreeMap.class);
            for (Map.Entry<UUID, Order> item : ordersLoc.entrySet()) {
                if (id.toString().equals(item.getKey())){
                    item.setValue(ord);
                    System.out.println("Заказ с данным ID изменен!");
                }
            }
            objectMapper.writeValue(new FileOutputStream(FILENAMETMP), ordersLoc);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        File file = new File(FILENAMETMP);
        File fileOut = new File(FILENAME);
        file.renameTo(fileOut);

        System.out.println("Изменение заказа с данным ID в файле .json выполнен успешно.");
    }

    @Override
    public void saveAll(TreeMap<UUID, Order> ordersLoc) {
        System.out.println("Cохранение в формате JSON: ");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("fileJSONwithOrders.json"), ordersLoc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Cохранение в формате JSON выполнено успешно! ");
    }

    @Override
    public void readAll() throws IOException, ClassNotFoundException {
        System.out.println("Чтение данных формата json из файла: ");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TreeMap<UUID, Order> ordersLoc = objectMapper.readValue(new File(FILENAME),
                    TreeMap.class);
            for (Map.Entry<UUID, Order> item : ordersLoc.entrySet()) {
                System.out.println(item.getKey());
                System.out.println(item.getValue());
            }
            System.out.println("Данные из файла:");
            System.out.println(ordersLoc);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        }

        System.out.println("Чтение данных формата json из файла выполнено успешно!");

    }
}
