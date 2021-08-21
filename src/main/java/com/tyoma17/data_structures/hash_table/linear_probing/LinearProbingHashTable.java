package com.tyoma17.data_structures.hash_table.linear_probing;

import com.tyoma17.data_structures.hash_table.StoredElement;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Array;

@Log4j2
public class LinearProbingHashTable<E> {

    private StoredElement<E>[] hashTable;
    private final Class<E> clazz;

    public LinearProbingHashTable(Class<E> clazz) {
        log.debug("Creating a {} hash table", clazz.getSimpleName());
        hashTable = (StoredElement<E>[]) Array.newInstance(StoredElement.class, 10);
        log.debug("The hash table has been initialized");
        this.clazz = clazz;
    }

    public void put(String key, E element) {
        log.debug("Putting {} to hash table...", element);
        int hashedKey = hashKey(key);
        log.debug("Hashed key of '{}' is {}", key, hashedKey);

        if (occupied(hashedKey)) {

            int stopIndex = hashedKey;

            if (hashedKey == hashTable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }

        }

        if (occupied(hashedKey)) {
            log.debug("There's already a reference at position {}", hashedKey);
        } else {
            hashTable[hashedKey] = new StoredElement<>(key, element);
            log.debug("Successfully added {} to hash table", element);
        }
    }

    public E get(String key) {
        log.debug("Retrieving from hash table by key '{}'...", key);
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            log.debug("No object by the key '{}' has been found", key);
            return null;
        }

        log.debug("Hashed key of '{}' is {}", key, hashedKey);
        return hashTable[hashedKey].getElement();
    }

    public E remove(String key) {
        log.debug("Removing from hash table by key = '{}'", key);
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            log.debug("No object by the key '{}' has been removed", key);
            return null;
        }

        E element = hashTable[hashedKey].getElement();
        hashTable[hashedKey] = null;

        log.debug("Rehashing hash table...");
        StoredElement<E>[] oldHashTable = hashTable;
        hashTable = (StoredElement<E>[]) Array.newInstance(StoredElement.class, oldHashTable.length);

        for (int i = 0; i < oldHashTable.length; i++) {
            if (oldHashTable[i] != null) {
                put(oldHashTable[i].getKey(), oldHashTable[i].getElement());
            }
        }
        log.debug("Successfully rehashed");

        log.debug("Successfully removed {}", element);
        return element;
    }

    public E get(int index) {
        StoredElement<E> storedElement = hashTable[index];
        return storedElement == null ? null : storedElement.getElement();
    }

    public String hashTableAsString() {

        StringBuilder stringBuilder = new StringBuilder("\n-------- HASH TABLE --------\n");

        for (int i = 0; i < hashTable.length; i++) {

            if (hashTable[i] == null) {
                stringBuilder
                        .append("Position [").append(i).append("] : ")
                        .append("null\n");
            } else {
                stringBuilder
                        .append("Position [").append(i).append("] : ")
                        .append(hashTable[i].getElement())
                        .append("\n");
            }
        }

        stringBuilder.append("-------- HASH TABLE --------");

        return stringBuilder.toString();
    }

    public int capacity() {
        return hashTable.length;
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length; // simulates collisions
    }

    private int findKey(String key) {
        log.debug("Searching for index of the key '{}'...", key);
        int hashedKey = hashKey(key);

        if (hashTable[hashedKey] != null && hashTable[hashedKey].getKey().equals(key)) {
            log.debug("Index of the key '{}' is {}", key, hashedKey);
            return hashedKey;
        }

        log.debug("Linear probing is being applied...");

        int stopIndex = hashedKey;

        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex
                && hashTable[hashedKey] != null
                && !hashTable[hashedKey].getKey().equals(key)) {

            hashedKey = (hashedKey + 1) % hashTable.length;

        }

        if (hashTable[hashedKey] != null
                && hashTable[hashedKey].getKey().equals(key)) {

            log.debug("Index of the key '{}' is {}", key, hashedKey);
            return hashedKey;

        } else {

            log.debug("Index of the key '{}' has not been found", key);
            return -1;
        }
    }

    private boolean occupied(int index) {
        return hashTable[index] != null;
    }
}