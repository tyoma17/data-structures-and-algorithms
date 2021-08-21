package com.tyoma17.data_structures.queue;

import com.tyoma17.data_structures.Person;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ArrayQueueClient {

    public static void main(String[] args) {

        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");
        Person johnnyRoe = new Person(5, "Johnny", "Roe");
        Person johnSmith = new Person(6, "John", "Smith");

        log.info("Creating queue of persons...");
        ArrayQueue<Person> queue = new ArrayQueue<>(Person.class, 2);
        log.info(queue.queueAsString());

        log.info("Adding {} to queue...", johnDoe);
        queue.add(johnDoe);
        log.info(queue.queueAsString());

        log.info("Adding {} to queue...", richardRoe);
        queue.add(richardRoe);
        log.info(queue.queueAsString());

        log.info("Removing from queue...");
        Person removedPerson = queue.remove();
        log.info(queue.queueAsString());
        log.info("Removed person: {}", removedPerson);

        log.info("Adding {} to queue...", janeRoe);
        queue.add(janeRoe);
        log.info(queue.queueAsString());

        log.info("Adding {} to queue...", babyDoe);
        queue.add(babyDoe);
        log.info(queue.queueAsString());

        log.info("Adding {} to queue...", johnnyRoe);
        queue.add(johnnyRoe);
        log.info(queue.queueAsString());

        log.info("Adding {} to queue...", johnSmith);
        queue.add(johnSmith);
        log.info(queue.queueAsString());

        log.info("Peeking from queue...");
        Person peekedPerson = queue.peek();
        log.info("Peeked person: {}", peekedPerson);

        while (!queue.isEmpty()) {
            log.info("Removing from queue...");
            removedPerson = queue.remove();
            log.info(queue.queueAsString());
            log.info("Removed person: {}", removedPerson);
        }
    }
}