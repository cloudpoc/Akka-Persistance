## Akka Persistence Samples

This POC contains examples that illustrate a subset of[Akka Persistence](http://doc.akka.io/docs/akka/2.5/java/persistence.html) features.

- persistent actor
- persistent actor recovery
- persistent actor views

## Persistent actor

[StateFullActor.java] is an example of persistent actor which will persist the message as a series of event before it updates/handle the same . We are consider this actor as statefull actor as it update its state(here with order details) wvwry time it gets new order


## Persistent actor recovery

[StateFullActor.java] is also responsible for recovering the event after evrytime it crashes and update its own state
In this POC we have taken current shopping cart is our actor internal state where it update the list every time he gets a new order

Note:- This might not be a good example for real time.

## Persistent actor views

[ViewActorApp.java] A perisitant actor persist the event into a immutable storage as bite format ,it means that you cannot manually query  or change the same. This is where aka view part comes into picture . Aka provides a way to read the event from the journel that peristent actor persist the events. And this should be seperate actor system all together to align with CQRS concept[Command Query responsibility separation  ]


To run this example, follow below steps
------------------------------------------------------
1) sbt run - with this it will show both option a)PersistentActorApp b) ViewActorApp
2) choose option a first as we need to fill our journel with some event
3) Next time when you run ,choose option as b which will demonstrate the view part of aka persistance


TO DO
--------------
Needs to implement saving the snapshot periodically 
