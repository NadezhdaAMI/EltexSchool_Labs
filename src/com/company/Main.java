package com.company;
//Вариант 2
//        Список объектов продажи элетроники 3-х видов: телефоны, сматфоны и планшеты.
//        Функция поиска товара в магазине и добавление в корзину: пользователь выбирает товар
//         и количество; выбранное добавляется в корзину автоматически!
//        После того как первый пользователь оформил покупку, корзина очищается
//          и становятся доступны функции "Показать ВСЕ заказы" и "Показать статусы заказов"

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.awt.*;
import java.util.*;

public class Main {

    public static void MenuClient() {
        System.out.println("Выберите пункт меню: ");
        System.out.println("1 - Найти и добавить товары в корзину"); // пользователь будет генерировать объекты сам, они сразу же добавяются в корзину
        System.out.println("2 - Показать товары, добавленные в корзину");
        System.out.println("3 - Найти товары в корзине");
        System.out.println("4 - Удалить товары из корзины");
        System.out.println("5 - Оформить покупку");
        System.out.println("6 - Показать ВСЕ заказы");
        System.out.println("7 - Показать статусы заказов");

        System.out.println("9 - EXIT");
    }

    public static void main(String[] args) {
        UUID ID;

        ShoppingCart shoppingCart = new ShoppingCart();

        Scanner n = new Scanner(System.in);

        Orders orders = new Orders();

        long startTime = System.currentTimeMillis();

        TreeMap<UUID, Orders> ordersProc = new TreeMap<>();

        while (true) {

            MenuClient();
            int menu = n.nextInt();

            if (menu == 1) { // Создать объект(ы) со случайными значениями и добавить в корзину
                System.out.println("Введите вид представления: ");
                System.out.println("1 - Telephonе");
                System.out.println("2 - Smartphone");
                System.out.println("3 - Tablet");

                int type = n.nextInt();
                if (type == 1 || type == 2 || type == 3){

                System.out.println("Введите кол-во объектов: ");
                int N = n.nextInt();
                if (type == 1) {
                    while (N != 0) {
                        ID = UUID.randomUUID();
                        Telephone telephone = new Telephone(ID);
                        telephone.create();
                        shoppingCart.add(telephone);
                        N--;
                    }
                    System.out.println("Товары добавлены в корзину!");

                } else if (type == 2) {
                    while (N != 0) {
                        ID = UUID.randomUUID();
                        Smartphone smartphone = new Smartphone(ID);
                        smartphone.create();
                        shoppingCart.add(smartphone);
                        N--;
                    }
                    System.out.println("Товары добавлены в корзину!");
                } else if (type == 3) {
                    while (N != 0) {
                        ID = UUID.randomUUID();
                        Tablet tablet = new Tablet(ID);
                        tablet.create();
                        shoppingCart.add(tablet);
                        N--;
                    }
                    System.out.println("Товары добавлены в корзину!");
                 }
                }
                else
                    System.out.println("Нет такого типа объектов. Попробуйте еще раз!");

            } else if (menu == 2) { // Вывод всех объектов из корзины на экран
                if (shoppingCart.shopCartSize() == 0)
                    System.out.println("Ваша корзина пуста! Сначала добавьте товары.. ");
                else {
                    System.out.println("Всего товаров в корзине: " + shoppingCart.shopCartSize());
                    System.out.println("Подробнее о каждом товаре: ");
                    shoppingCart.showOrderIn();}

            } else if (menu == 3) { //поиск в корзине по айди
                if (shoppingCart.shopCartSize() == 0)
                    System.out.println("Ваша корзина пуста! Сначала добавьте товары.. ");
                else {
                    System.out.println("Введите ID товара: ");
                    String id = n.next();
                    Electronics l = shoppingCart.search(id);
                    if (l != null) {
                        System.out.println("Товар в корзине найден!");
                        System.out.println("Искомый товар: ");
                        System.out.println(l.toString());
                    }
                    else System.out.println("В корзине нет товара с таким ID!");
                }

            } else if (menu == 4) {   // Удалить товары из корзины
                if (shoppingCart.shopCartSize() == 0)
                    System.out.println("Ваша корзина пуста! Сначала добавьте товары.. ");
                else {
                    System.out.println("Введите ID товара, который хотите удалить из корзины: ");
                    String id = n.next();
                    Electronics l1 = shoppingCart.search(id);
                    if (l1 != null) {
                        shoppingCart.delObjectInShopC(l1);
                        System.out.println("Товар из корзины удален!");
                    }
                    else System.out.println("В корзине нет товара с таким ID!");
                }

            } else if (menu == 5) {     // оформить покупку
                if (shoppingCart.shopCartSize() == 0)
                    System.out.println("Ваша корзина пуста! Сначала добавьте товары.. ");
                else {
                    System.out.println("Введите данные(ФИО и email)");
                    Credentials credential = new Credentials();
                    credential.IDClient = UUID.randomUUID();
                    System.out.println("Введите фамилию:");
                    credential.Surname = n.next();
//                System.out.println("Введите имя:");
//                credential.Name = n.next();
//                System.out.println("Введите отчество:");
//                credential.MiddleName = n.next();
//                System.out.println("Введите email:");
//                credential.Email = n.next();;

                    Orders order = new Orders();
                    order.checkout(credential, shoppingCart);
                    System.out.println("Заказ создан!");
                    ordersProc.put(order.getIDOrder(), order);

                    System.out.println("Дата оформления заказа: ");
                    System.out.println(order.getDateCreation()); //  время оформления заказа< переделать!

//                    System.out.println("***Подробнее о заказе: ");
//                    order.showOrder();
                    orders.add(order);
                    credential.delete();
                    shoppingCart.clearShopCart();
                }


            } else if (menu == 6) { //Показать все заказы
                System.out.println("Все заказы: ");
                orders.showOrdersAll();

            } else if (menu == 7) {   //Показать статусы всех заказов
                System.out.println("Проверка статуса заказов...");
                ordersProc = orders.testOrders(ordersProc);
                if (ordersProc.size() == 0){
                    System.out.println("Все заказы обработаны!");
                }
                else {
                    System.out.println("А эти заказы еще в процессе обработки: ");
                    for (Map.Entry<UUID, Orders> item: ordersProc.entrySet()){
                        System.out.println("ID заказа: " + item.getKey() + ", " + " заказ: "+ item.getValue());
                    }
                }

            } else if (menu == 9) {
                long finishTime = System.currentTimeMillis();
                System.out.println("Программа выполнялась: " + (finishTime - startTime)/1000 + " секунд");
                break;
            } else {
                System.out.println("Нет такого пункта меню. Попробуйте еще раз!");
            }
        }
    }
}
