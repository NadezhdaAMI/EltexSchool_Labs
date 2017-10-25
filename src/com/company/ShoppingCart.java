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

    public ShoppingCart() {
        this.shopCart = shopCart;
    }

    public Electronics get(int index){
        return (Electronics)shopCart.get(index);
    }

    public void add(Electronics object){
        shopCart.add(object);

    }

    public void delete(Electronics object){
        shopCart.remove(object);

    }

    public int getSize(){
        return shopCart.size();
    }

    @Override
    public String toString() {
        return "Выбранные товары: " + "\n" + shopCart;
    }
}
