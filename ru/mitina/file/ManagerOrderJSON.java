package ru.mitina.file;

import ru.mitina.orders.Order;

import java.util.TreeMap;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder {        //для хранения заказов в виде текстового файла в формате JSON


    @Override
    public void saveById(UUID id, Order ord) {
    }

    @Override
    public Order readById(UUID id) {
        return null;
    }

    @Override
    public void saveAll(TreeMap<UUID, Order> ordersLoc) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("order", "ord");
//        System.out.println(jsonObject.toJSONString());

    }

    @Override
    public void readAll() {


    }
}
