package com.company;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart<T extends Electronics>{

    private List<T> shopCart = new LinkedList<>();

    public T search(String id){  // поиск товара в корзине по айди.
        for (T k: shopCart) {
            if (k.IDelectronics.toString().equals(id)){
                return k;
            }
        }
        return null;
    }

    public void showOrderIn(){
        for (Electronics k: shopCart) {
            System.out.println(k.toString());
        }
    }

    public ShoppingCart() {
        this.shopCart = shopCart;
    }

    public void add(T object){
        shopCart.add(object);
    }

    public void clearShopCart(){
        shopCart.clear();
    }

    public void delObjectInShopC(T o){
        shopCart.remove(o);
    }

    public int shopCartSize(){
        return shopCart.size();
    }

    @Override
    public String toString() {
        return /*"\n" + */shopCart.toString();
    }
}
