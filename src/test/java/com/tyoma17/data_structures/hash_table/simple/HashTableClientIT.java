package com.tyoma17.data_structures.hash_table.simple;

import com.tyoma17.data_structures.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HashTableClientIT {

    @Test
    void testSimpleHashTable() {
        Person johnDoe = new Person(1, "John", "Doe");
        Person artyomShootov = new Person(2, "Artyom", "Shootov");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person johnSmith = new Person(4, "John", "Smith");

        HashTable<Person> hashTable = new HashTable<>(Person.class);
        assertEquals(10, hashTable.capacity());
        for (int i = 0; i < hashTable.capacity(); i++) {
            assertNull(hashTable.get(i));
        }

        hashTable.put(johnDoe.getLastName(), johnDoe);
        assertEquals(johnDoe, hashTable.get(johnDoe.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3) {
                continue;
            }

            assertNull(hashTable.get(i));
        }

        hashTable.put(johnSmith.getLastName(), johnSmith);
        assertEquals(johnSmith, hashTable.get(johnSmith.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 5) {
                continue;
            }

            assertNull(hashTable.get(i));
        }

        hashTable.put(artyomShootov.getLastName(), artyomShootov);
        assertEquals(artyomShootov, hashTable.get(artyomShootov.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 5 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i));
        }

        hashTable.put(janeRoe.getLastName(), janeRoe);
        assertEquals(johnDoe, hashTable.get(janeRoe.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 5 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i));
        }
    }
}