package com.persistence;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * Created by bthiru on 11/21/2017.
 */
public class PersistantActorApp {

    public static void main(String... args) throws Exception {
        final ActorSystem system = ActorSystem.create("akkaPersistanceDemo");
        final ActorRef stateFullActor = system.actorOf(Props.create(StateFullActor.class), "StateFullActor");
        stateFullActor.tell(new Order("DinnerSet"), null);
        stateFullActor.tell(new Order("Table"), null);
        stateFullActor.tell(new Order("SofaSet"), null);

        Thread.sleep(10000);
        system.terminate();
    }
}
