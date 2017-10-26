package com.company;
//Вариант 2
//        Список объектов продажи элетроники 3-х видов: телефоны, сматфоны и планшеты.
//        Поля базового класса:
//        ID товара
//        Название
//        Цена
//        Счётчик товаров
//        Фирма
//        Модель
//        ОС
//        ///Поля для телефонов:
//        Тип корпуса (классический, раскладушка)
//       //// Поля для сматфонов:
//        Тип SIM-карты (micro-SIM, обычная)
//        Количество SIM-карт
//       //// Поля для планшетов:
//        Видеопроцессор
//        Разрешение экрана

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.awt.*;
import java.util.*;

public class Main {

    public static void MenuSeller() {
        System.out.println("Выберете пункт меню: ");
        System.out.println("1 - Создать объект(ы) со случайными значениями");
        System.out.println("2 - Вывод всех объектов на экран");
        System.out.println("3 - Ввести данные для объекта с клавиатуры");
        System.out.println("4 - Удалить объект(ы)");
        System.out.println("5 - EXIT");
    }

    public static void MenuClient() {
        System.out.println("Выберете пункт меню: ");
        System.out.println("1 - Найти и добавить товары в корзину"); // пользователь будет генерировать объекты сам, они сразу же добавяются в корзину
        System.out.println("2 - Показать товары, добавленные в корзину");
        System.out.println("3 - Найти товары в корзине");
        System.out.println("4 - Удалить товары из корзины");

        System.out.println("5 - Оформить покупку");
        System.out.println("6 - Показать ВСЕ заказы");
//        System.out.println("7 - Показать статусы заказов");

        System.out.println("9 - EXIT");
    }

    public static void main(String[] args) {
        UUID ID;

        ArrayList<Electronics> electronics = new ArrayList<>();

//        List<Electronics> shoppingCart = new LinkedList<Electronics>();

        ShoppingCart shoppingCart = new ShoppingCart();

        Scanner n = new Scanner(System.in);

        Orders orders = new Orders();

        long startTime = System.currentTimeMillis();

        TreeMap<UUID, Orders> ordersProc = new TreeMap<UUID, Orders>();

        while (true) {

            MenuClient();
            int menu = n.nextInt();

            if (menu == 1) { // Создать объект(ы) со случайными значениями и добавить в корзину
                System.out.println("Введите вид представления: ");
                System.out.println("1 - Telephonе");
                System.out.println("2 - Smartphone");
                System.out.println("3 - Tablet");

                int type = n.nextInt();

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

                } else
                    System.out.println("Нет такого типа объектов. Попробуйте еще раз!");
            } else if (menu == 2) { // Вывод всех объектов из корзины на экран
                System.out.println("Всего объектов: " + Electronics.getCountElectronics());
                System.out.println("Объекты: ");
                shoppingCart.showOrderIn();

//            } else if (menu == 3) { // создание объекта вручную
//                System.out.println("Введите вид представления: ");
//                System.out.println("1 - Telephonе");
//                System.out.println("2 - Smartphone");
//                System.out.println("3 - Tablet");
//                int type = n.nextInt();
//                System.out.println("Введите кол-во объектов, которое вы хотите создать: ");
//                int N = n.nextInt();
//                if (type == 1) {
//                    while (N != 0) {
//                        ID = UUID.randomUUID();
//                        Telephone telephone = new Telephone(ID);
//                        telephone.update();
//                        electronics.add(telephone);
//                        N--;
//                    }
//
//                } else if (type == 2) {
//                    while (N != 0) {
//                        ID = UUID.randomUUID();
//                        Smartphone smartphone = new Smartphone(ID);
//                        smartphone.update();
//                        electronics.add(smartphone);
//                        N--;
//                    }
//                } else if (type == 3) {
//                    while (N != 0) {
//                        ID = UUID.randomUUID();
//                        Tablet tablet = new Tablet(ID);
//                        tablet.update();
//                        electronics.add(tablet);
//                        N--;
//                    }
//
//                } else {
//                    System.out.println("Нет такого типа объектов. Попробуйте еще раз!");
//                }

            } else if (menu == 16) {// удалить объект
                System.out.println("Введите тип объектов для удаления: ");
                System.out.println("1 - Telephonе");
                System.out.println("2 - Smartphone");
                System.out.println("3 - Tablet");
                int type = n.nextInt();
                if (type == 1) {
                    for (Electronics count : electronics) {
                        if (count instanceof Telephone)
                            count.delete();

                    }
                    System.out.println("Все данные в объектах типа Telephonе удалены!");
                } else if (type == 2) {
                    for (Electronics count : electronics) {
                        if (count instanceof Smartphone)
                            count.delete();
                    }
                    System.out.println("Все данные в объектах типа Smartphone удалены!");
                } else if (type == 3) {
                    for (Electronics count : electronics) {
                        if (count instanceof Tablet)
                            count.delete();
                    }
                    System.out.println("Все данные в объектах типа Tablet удалены!");

                } else
                    System.out.println("Нет такого типа объектов. Попробуйте еще раз!");

            } else if (menu == 3) { //поиск в корзине по айди
                System.out.println("Введите ID товара: ");
                String id = n.next();
                Electronics l = shoppingCart.search(id);
                System.out.println("Товар в корзине найден!");
                System.out.println("Искомый товар: ");
                System.out.println(l.toString());

            } else if (menu == 4) {   // Удалить товары из корзины
                System.out.println("Введите ID товара, который хотите удалить: ");
                String id = n.next();
                Electronics l1 = shoppingCart.search(id);
                shoppingCart.delObjectInShopC(l1);
                System.out.println("Товар из корзины удален!");

            } else if (menu == 5) {     // оформить покупку
                System.out.println("Введите данные(ФИО и email)");
                Credentials credential = new Credentials();
                credential.IDClient = UUID.randomUUID();
                System.out.println("Введите фамилию:");
                credential.Surname = n.next();
                System.out.println("Введите имя:");
                credential.Name = n.next();
                System.out.println("Введите отчество:");
                credential.MiddleName = n.next();
                System.out.println("Введите email:");
                credential.Email = n.next();;

                Orders order = new Orders();
                order.checkout(credential, shoppingCart);
                System.out.println("Заказ создан!");
                System.out.println("Дата оформления заказа: ");
                System.out.println(orders.getTimeCreation()); //  дата оформления заказа< переделать!

                System.out.println("***Подробнее о заказе: ");
                order.showOrder();

                orders.add(order);
                credential.delete();
                shoppingCart.clearShopCart();

            }else if (menu == 6) { //Показать все заказы
                System.out.println("Все заказы: ");
                orders.showOrdersAll();
            }else if (menu == 7) {   //Показать статусы всех заказов


            }else if (menu == 9) {
                long finishTime = System.currentTimeMillis();
                System.out.println("Программа выполнялась: " + (finishTime - startTime)/1000 + " секунд");
                break;
            } else {
                System.out.println("Нет такого пункта меню. Попробуйте еще раз!");
            }
        }
    }
}
