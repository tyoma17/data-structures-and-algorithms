package com.tyoma17.data_structures.hash_table.chained;

import com.tyoma17.data_structures.hash_table.StoredElement;
import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;
import java.util.ListIterator;

@Log4j2
public class ChainedHashTable<E> {

    private LinkedList<StoredElement<E>>[] hashTable;

    public ChainedHashTable() {
        log.debug("Creating a hash table...");
        hashTable = new LinkedList[10];

        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }

        log.debug("The hash table has been initialized");
    }

    public void put(String key, E element) {
        log.debug("Putting {} to hash table...", element);
        int hashedKey = hashKey(key);
        log.debug("Hashed key of '{}' is {}", key, hashedKey);
        hashTable[hashedKey].add(new StoredElement<>(key, element));
        log.debug("Successfully added {} to hash table", element);
    }

    public E get(String key) {
        log.debug("Retrieving from hash table by key '{}'...", key);
        int hashedKey = hashKey(key);
        log.debug("Hashed key of '{}' is {}", key, hashedKey);
        ListIterator<StoredElement<E>> iterator = hashTable[hashedKey].listIterator();
        StoredElement<E> storedElement;

        while (iterator.hasNext()) {
            storedElement = iterator.next();
            if (storedElement.getKey().equals(key)) {
                return storedElement.getElement();
            }
        }

        log.debug("No object by the key '{}' has been found", key);
        return null;
    }

    public LinkedList<StoredElement<E>> get(int index) {
        return hashTable[index];
    }

    public E remove(String key) {
        log.debug("Removing from hash table by key = '{}'...", key);
        int hashedKey = hashKey(key);
        log.debug("Hashed key of '{}' is {}", key, hashedKey);
        ListIterator<StoredElement<E>> iterator = hashTable[hashedKey].listIterator();
        StoredElement<E> storedElement = null;
        int index = -1;

        while (iterator.hasNext()) {
            storedElement = iterator.next();
            index++;
            if (storedElement.getKey().equals(key)) {
                break;
            }
        }

        if (storedElement == null || !key.equals(storedElement.getKey())) {
            log.debug("No object by the key '{}' has been removed", key);
            return null;
        } else {
            hashTable[hashedKey].remove(index);
            log.debug("Successfully removed {}", storedElement.getElement());
            return storedElement.getElement();
        }
    }

    private int hashKey(String key) { // simulates collisions
        return key.length() % hashTable.length;
    }

    public String hashTableAsString() {

        StringBuilder stringBuilder = new StringBuilder("\n-------- HASH TABLE --------\n");

        for (int i = 0; i < hashTable.length; i++) {

            if (hashTable[i].isEmpty()) {
                stringBuilder
                        .append("Position [").append(i).append("] : ")
                        .append("null\n");
            } else {
                stringBuilder
                        .append("Position [").append(i).append("] : ");

                ListIterator<StoredElement<E>> iterator = hashTable[i].listIterator();
                while (iterator.hasNext()) {
                    stringBuilder
                            .append(iterator.next().getElement())
                            .append(" -> ");
                }
                stringBuilder.append("null\n");

            }
        }

        stringBuilder.append("-------- HASH TABLE --------");

        return stringBuilder.toString();
    }

    public int keysCapacity() {
        return hashTable.length;
    }
}