package com.tyoma17.data_structures.hash_table.linear_probing;

import com.tyoma17.data_structures.Person;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LinearProbingHashTableClient {

    public static void main(String[] args) {

        Person johnDoe = new Person(1, "John", "Doe");
        Person artyomShootov = new Person(2, "Artyom", "Shootov");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person alexKing = new Person(5, "Alex", "King");

        log.info("Creating hash table of persons...");
        LinearProbingHashTable<Person> hashTable = new LinearProbingHashTable<>(Person.class);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", johnDoe);
        hashTable.put(johnDoe.getLastName(), johnDoe);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", alexKing);
        hashTable.put(alexKing.getLastName(), alexKing);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", artyomShootov);
        hashTable.put(artyomShootov.getLastName(), artyomShootov);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", janeRoe);
        hashTable.put(janeRoe.getLastName(), janeRoe);
        log.info(hashTable.hashTableAsString());

        log.info("Retrieving a person by key = '{}'...", johnDoe.getLastName());
        log.info("Retrieved person: {}", hashTable.get(johnDoe.getLastName()));

        log.info("Retrieving a person by key = '{}'...", alexKing.getLastName());
        log.info("Retrieved person: {}", hashTable.get(alexKing.getLastName()));

        log.info("Retrieving a person by key = '{}'...", artyomShootov.getLastName());
        log.info("Retrieved person: {}", hashTable.get(artyomShootov.getLastName()));

        log.info("Retrieving a person by key = '{}'...", janeRoe.getLastName());
        log.info("Retrieved person: {}", hashTable.get(janeRoe.getLastName()));

        log.info("Removing a person by key = '{}'...", johnDoe.getLastName());
        log.info("Removed person: {}", hashTable.remove(johnDoe.getLastName()));
        log.info(hashTable.hashTableAsString());

        log.info("Removing a person by key = '{}'...", alexKing.getLastName());
        log.info("Removed person: {}", hashTable.remove(alexKing.getLastName()));
        log.info(hashTable.hashTableAsString());

        log.info("Retrieving a person by key = '{}'...", janeRoe.getLastName());
        log.info("Retrieved person: {}", hashTable.get(janeRoe.getLastName()));
    }
}
