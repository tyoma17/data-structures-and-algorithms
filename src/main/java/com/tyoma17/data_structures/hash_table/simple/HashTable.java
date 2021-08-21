package com.tyoma17.data_structures.hash_table.simple;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Array;

@Log4j2
public class HashTable<E> {

    private E[] hashTable;
    private final Class<E> clazz;

    public HashTable(Class<E> clazz) {
        log.debug("Creating a {} hash table", clazz.getSimpleName());
        hashTable = (E[]) Array.newInstance(clazz, 10);
        log.debug("The hash table has been initialized");
        this.clazz = clazz;
    }

    public void put(String key, E element) {
        log.debug("Putting {} to hash table...", element);
        int hashedKey = hashKey(key);
        log.debug("Hashed key of '{}' is {}", key, hashedKey);

        if (hashTable[hashedKey] != null) { // the implementation doesn't handle collisions
            log.debug("There's already a reference at position {}", hashedKey);
        } else {
            hashTable[hashedKey] = element;
            log.debug("Successfully added {} to hash table", element);
        }
    }

    public E get(String key) {
        log.debug("Retrieving from hash table...");
        int hashedKey = hashKey(key);
        log.debug("Hashed key of '{}' is {}", key, hashedKey);
        return hashTable[hashedKey];
    }

    public E get(int index) {
        return hashTable[index];
    }

    public String hashTableAsString() {

        StringBuilder stringBuilder = new StringBuilder("\n-------- HASH TABLE --------\n");

        for (E e : hashTable) {
            stringBuilder.append(e).append("\n");
        }

        stringBuilder.append("-------- HASH TABLE --------");

        return stringBuilder.toString();
    }

    public int capacity() {
        return hashTable.length;
    }

    private int hashKey(String key) { // simulates collisions
        return key.length() % hashTable.length;
    }
}
