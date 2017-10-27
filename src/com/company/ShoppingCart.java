package com.company;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart{

    private List<Electronics> shopCart = new LinkedList<>();

    public Electronics search(String id){  // поиск товара в корзине по айди.
        for (Electronics k: shopCart) {
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

    public void add(Electronics object){
        shopCart.add(object);
    }

    public void clearShopCart(){
        shopCart.clear();
    }

    public void delObjectInShopC(Electronics o){
        shopCart.remove(o);
    }

    public int shopCartSize(){
        return shopCart.size();
    }

    @Override
    public String toString() {
        return "\n" + shopCart;
    }
}
