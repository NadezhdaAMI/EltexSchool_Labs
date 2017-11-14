package com.company;
//Вариант 2
//        Список объектов продажи элетроники 3-х видов: телефоны, сматфоны и планшеты.
//        Функция поиска товара в магазине и добавление в корзину: пользователь выбирает товар
//         и количество; выбранное добавляется в корзину автоматически!
//        !!! ТОЛЬКО После того как первый пользователь оформил покупку, корзина очищается
//          и становятся доступны функции "Показать ВСЕ заказы" и "Показать статусы заказов"

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void MenuClient() {
        System.out.println("Выберите пункт меню: ");
        System.out.println("0 - Введите количество покупателей");
//        System.out.println("1 - Найти и добавить товары в корзину"); // пользователь будет генерировать объекты сам, они сразу же добавяются в корзину
//        System.out.println("2 - Показать товары, добавленные в корзину");
//        System.out.println("3 - Найти товары в корзине");
//        System.out.println("4 - Удалить товары из корзины");
//        System.out.println("5 - Оформить покупку");
        System.out.println("6 - Показать ВСЕ заказы");
        System.out.println("7 - Показать статусы заказов");
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

        List<Electronics> shopCart = new LinkedList<>();

        ShoppingCart shoppingCart = new ShoppingCart();

        Scanner n = new Scanner(System.in);

        Orders orders = new Orders();

        long startTime = System.currentTimeMillis();

        TreeMap<UUID, Orders> ordersProc = new TreeMap<>();

        while (true) {

            MenuClient();
            int menu = n.nextInt();

            if (menu == 0){ //Ввести количество покупателей и Создать заказы
                System.out.println("Введите количество клиентов:");
                int countClients = n.nextInt();
                for (int i = 0; i < countClients; i++) {
                    System.out.println("Регистрация клиента");

                    Credentials credential = new Credentials();

                    randomCredential(credential);

                    randomShoppingCart(shoppingCart);

                    Orders order = new Orders();
                    order.checkout(credential, shoppingCart);
                    System.out.println("Заказ создан!");
                    ordersProc.put(order.getIDOrder(), order);

                    System.out.println("Дата оформления заказа: ");
//                    System.out.println(order.getDateCreation()); //
                    orders.add(order);
                    shoppingCart.clearShopCart();
                }

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

                }


            } else if (menu == 6) { //Показать все заказы
                if (orders.size() == 0){
                    System.out.println("Заказов для обработки пока нет!");
                } else {
                        System.out.println("Все заказы: ");
                        orders.showOrdersAll();
                }

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
