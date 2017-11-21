/**
 * Copyright (C) 2009-2016 Lightbend Inc. <http://www.lightbend.com>
 */

package com.persistence;

//#persistent-actor-example

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.persistence.AbstractPersistentActor;
import akka.persistence.SnapshotOffer;

import java.io.Serializable;
import java.util.ArrayList;

import static java.util.Arrays.asList;


class StateFullActor extends AbstractPersistentActor {

    private ShoppingCart sCart = new ShoppingCart();

    @Override
    public String persistenceId() { return "shoppingCart-test-1"; }

    @Override
    public Receive createReceiveRecover() {
        return receiveBuilder()
            .match(Order.class, order -> {
                sCart.update(order);
                for(Order ordr:sCart.getCurrentCart()) {
                    System.out.println("Order List after restarting -->" +ordr.getProductName());
                }
            })
            .build();
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(Order.class, order -> {

                persist(order, (Order order1) -> {
                    sCart.update(order1);
                    getContext().system().eventStream().publish(order1);
                    for(Order ordr:sCart.getCurrentCart()) {
                        System.out.println("Order List after persisting -->" +ordr.getProductName());
                    }
                });
            })
            .build();
    }

}

