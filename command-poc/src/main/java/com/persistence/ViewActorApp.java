package com.persistence;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.persistence.query.EventEnvelope;
import akka.persistence.query.PersistenceQuery;
import akka.persistence.query.journal.leveldb.javadsl.LeveldbReadJournal;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Source;

/**
 * Created by bthiru on 11/21/2017.
 */
public class ViewActorApp {

    public static void main(String... args) throws Exception {
        final ActorSystem system = ActorSystem.create("akkaPersistanceDemo-View");

        final ActorMaterializer mat = ActorMaterializer.create(system);
        LeveldbReadJournal queries =
                PersistenceQuery.get(system).getReadJournalFor(LeveldbReadJournal.class,
                        LeveldbReadJournal.Identifier());

        Source<EventEnvelope, NotUsed> source =
                queries.eventsByPersistenceId("shoppingCart-test-1", 0, Long.MAX_VALUE);

                source.runForeach(envelope->{
                    //System.out.println("Order List from Journal -->"+envelope.event());

                        System.out.println("Order List from Journal -->" +((Order)envelope.event()).getProductName());
                },mat);
    }
}
