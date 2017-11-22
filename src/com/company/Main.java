package com.company;
//Вариант 2
//        Список объектов продажи элетроники 3-х видов: телефоны, сматфоны и планшеты.

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static TreeMap<UUID, Order> ordersProc = new TreeMap<>();

    public static void MenuClient() {
        System.out.println("Выберите пункт меню: ");
        System.out.println("0 - Введите количество покупателей");
        System.out.println("6 - Показать ВСЕ заказы");
        System.out.println("9 - EXIT");
    }

    public static Credentials randomCredential(Credentials cred){

        Random random = new Random();
        cred.IDClient = UUID.randomUUID();

        String[] surnameArr = {"Ivanov", "Petrov", "Makarov"};
        int index_surname = random.nextInt(surnameArr.length);
        cred.Surname = surnameArr[index_surname];

        String[] nameArr = {"Alex", "Djon", "Gena"};
        int index_name = random.nextInt(nameArr.length);
        cred.Name = nameArr[index_name];

        String[] middlenameArr = {"A.", "D.", "B."};
        int index_middlename = random.nextInt(middlenameArr.length);
        cred.MiddleName = middlenameArr[index_middlename];

        String[] emailArr = {"nn19005@mail.ru", "ooolkl003@yandex.ru", "spanchbob3@gmail.com"};
        int index_email = random.nextInt(emailArr.length);
        cred.Email = emailArr[index_email];

        return cred;
    }
    public static ShoppingCart randomShoppingCart(ShoppingCart shopcart){
        UUID ID;
        Random random= new Random();
        int T = random.nextInt(5);
        for (int i = 0; i < T; i++) {
            ID = UUID.randomUUID();
            Telephone telephone = new Telephone(ID);
            telephone.create();
            shopcart.add(telephone);
        }
        int S = random.nextInt(5);
        for (int i = 0; i < S; i++) {
            ID = UUID.randomUUID();
            Smartphone smartphone = new Smartphone(ID);
            smartphone.create();
            shopcart.add(smartphone);
        }
        int Tb = random.nextInt(5);
        for (int i = 0; i < Tb; i++) {
            ID = UUID.randomUUID();
            Tablet tablet = new Tablet(ID);
            tablet.create();
            shopcart.add(tablet);
        }
        return shopcart;
    }

    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        Orders orders = new Orders();
        long startTime = System.currentTimeMillis();

        while (true) {
            MenuClient();
            int menu = n.nextInt();
            if (menu == 0){ //Ввести количество покупателей и Создать заказы
                System.out.println("Введите количество клиентов:");
                int countClients = n.nextInt();
                for (int i = 0; i < countClients; i++) {
                    System.out.println("Регистрация клиента №" + (i + 1) + ": ");

                    Credentials credential = new Credentials();
                    ShoppingCart shoppingCart = new ShoppingCart();
                    randomCredential(credential);
                    randomShoppingCart(shoppingCart);
                    orders.checkout(credential, shoppingCart);

                    Order order = (Order) orders.returnOrderONE(i);
                    ordersProc.put(order.getIDOrder(), order);

                    CheckAwaiting checkAwaiting = new CheckAwaiting(ordersProc);
                    Thread threadAwaiting = new Thread(checkAwaiting);
                    threadAwaiting.setName("Поток №1 поиска оформленных заказов ");
                    threadAwaiting.start();
                    CheckProcessed checkProcessed = new CheckProcessed(ordersProc);
                    Thread threadProcessed = new Thread(checkProcessed);
                    threadProcessed.setName("Поток №2 поиска обработанных заказов ");
                    threadProcessed.start();
                    try {                                                               // чтобы потоки завершили свою работу до того, как появятся пункты меню
                        threadAwaiting.join();
                        threadProcessed.join();
                    } catch (InterruptedException e) {
                    }
                }
            }
            else if (menu == 6) { //Показать все заказы
                if (orders.size() == 0){
                    System.out.println("Заказов для обработки пока нет!");
                } else {
                        System.out.println("Все заказы: ");
                        for (int i = 0; i < orders.size(); i++) {
                            Order order = (Order) orders.returnOrderONE(i);
                            System.out.println(order.toString() + " " + ordersProc.get(order.getIDOrder()).getCart().toString());
                        }
                }
            }
            else if (menu == 9) {
                long finishTime = System.currentTimeMillis();
                System.out.println("Программа выполнялась: " + (finishTime - startTime)/1000 + " секунд");
                break;
            } else {
                System.out.println("Нет такого пункта меню. Попробуйте еще раз!");
            }
        }
    }
}
