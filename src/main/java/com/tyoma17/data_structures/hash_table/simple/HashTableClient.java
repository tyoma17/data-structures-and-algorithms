package com.tyoma17.data_structures.hash_table.simple;

import com.tyoma17.data_structures.Person;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashTableClient {

    public static void main(String[] args) {

        Person johnDoe = new Person(1, "John", "Doe");
        Person artyomShootov = new Person(2, "Artyom", "Shootov");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person johnSmith = new Person(4, "John", "Smith");

        log.info("Creating hash table of persons...");
        HashTable<Person> hashTable = new HashTable<>(Person.class);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", johnDoe);
        hashTable.put(johnDoe.getLastName(), johnDoe);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", johnSmith);
        hashTable.put(johnSmith.getLastName(), johnSmith);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", artyomShootov);
        hashTable.put(artyomShootov.getLastName(), artyomShootov);
        log.info(hashTable.hashTableAsString());

        log.info("Putting {} to hash table", janeRoe);
        hashTable.put(janeRoe.getLastName(), janeRoe);
        log.info(hashTable.hashTableAsString());

        log.info("Retrieving a person by key = '{}'...", johnDoe.getLastName());
        log.info("Retrieved person: {}", hashTable.get(johnDoe.getLastName()));

        log.info("Retrieving a person by key = '{}'...", johnSmith.getLastName());
        log.info("Retrieved person: {}", hashTable.get(johnSmith.getLastName()));

        log.info("Retrieving a person by key = '{}'...", artyomShootov.getLastName());
        log.info("Retrieved person: {}", hashTable.get(artyomShootov.getLastName()));
    }
}
