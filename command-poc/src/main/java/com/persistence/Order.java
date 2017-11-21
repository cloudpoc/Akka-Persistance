package com.persistence;

import akka.serialization.Serializer;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by bthiru on 11/21/2017.
 */
public class Order implements Serializable{

    Random random = new Random();

    public Order(String name){
        this.orderID=String.valueOf(random.nextInt(100));
        this.productName=orderID+"@"+name;
    }
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String orderID;
    private String productName;
}
