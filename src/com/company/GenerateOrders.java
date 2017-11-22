package com.company;

import java.util.TreeMap;
import java.util.UUID;

import static com.company.Main.ordersProc;
import static com.company.Main.randomCredential;
import static com.company.Main.randomShoppingCart;

public class GenerateOrders implements Runnable {

    private int CountClients;

    public GenerateOrders(int countClients) {
        CountClients = countClients;
    }

    public void run() {
        createOrders(CountClients);
    }

    public int getCountClients() {
        return CountClients;
    }

    public synchronized void createOrders(int countClients) {
        System.out.println("Автоматическая генерация заказов: ");

        Orders orders = new Orders();
        for (int i = 0; i < countClients; i++) {
            System.out.println("Регистрация клиента №" + (i + 1) + ": ");

            Credentials credential = new Credentials();
            ShoppingCart shoppingCart = new ShoppingCart();
            randomCredential(credential);
            randomShoppingCart(shoppingCart);
            orders.checkout(credential, shoppingCart);

            Order order = (Order) orders.returnOrderONE(i);
            ordersProc.put(order.getIDOrder(), order);
        }
        System.out.println("Все заказы: ");
        orders.showOrdersAll();
    }
}
