package ru.mitina.file;

import ru.mitina.orders.Order;
import ru.mitina.orders.Orders;

import java.util.TreeMap;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder {        //для хранения заказов в виде текстового файла в формате JSON

    @Override
    public UUID readById() {
        return null;
    }

    @Override
    public UUID saveAll(TreeMap<UUID, Order> ordersLoc) {
        return null;
    }

    @Override
    public Orders readAll(TreeMap<UUID, Order> ordersLoc) {
        return null;
    }
}
