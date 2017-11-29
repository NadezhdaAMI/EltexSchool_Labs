package ru.mitina.file;

import ru.mitina.orders.Order;
import ru.mitina.orders.Orders;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.TreeMap;
import java.util.UUID;

public interface IOrder {

    public UUID readById();

    public void saveAll(TreeMap<UUID, Order> ordersLoc);

//    public readAll();

    public void readAll() throws IOException, ClassNotFoundException;

}
