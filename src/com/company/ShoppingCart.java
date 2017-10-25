package com.company;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart<Electronics> {

    private List<Electronics> shopCart = new LinkedList<>();

    // поиск товара в корзине по айди.

    // показать все объекты в корзине


//    public ShoppingCart(LinkedList<Electronics> shopCart) {
//        this.shopCart = shopCart;
//    }

    public Electronics get(int index){
        return (Electronics)shopCart.get(index);
    }

    public void add(Electronics object){
        shopCart.add(object);

    }

    public void delete(Electronics object){
        shopCart.remove(object);

    }
}
