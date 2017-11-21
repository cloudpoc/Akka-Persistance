package com.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bthiru on 11/21/2017.
 */
public class ShoppingCart {


    public List<Order> getCurrentCart() {
        return currentCart;
    }

    public void setCurrentCart(List<Order> currentCart) {
        this.currentCart = currentCart;
    }

    private List<Order> currentCart;
    public void update(Order order){

        if(currentCart==null){
            currentCart = new ArrayList<Order>();
        }
        currentCart.add(order);
    }
}
