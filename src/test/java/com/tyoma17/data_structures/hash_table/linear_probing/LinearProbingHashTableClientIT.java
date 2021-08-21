package com.tyoma17.data_structures.hash_table.linear_probing;

import com.tyoma17.data_structures.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinearProbingHashTableClientIT {

    @Test
    void testHashTableWithLinearProbingAsCollisionHandler() {

        Person johnDoe = new Person(1, "John", "Doe");
        Person artyomShootov = new Person(2, "Artyom", "Shootov");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person alexKing = new Person(5, "Alex", "King");

        LinearProbingHashTable<Person> hashTable = new LinearProbingHashTable<>(Person.class);
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

        hashTable.put(alexKing.getLastName(), alexKing);
        assertEquals(alexKing, hashTable.get(alexKing.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 4) {
                continue;
            }

            assertNull(hashTable.get(i));
        }

        hashTable.put(artyomShootov.getLastName(), artyomShootov);
        assertEquals(artyomShootov, hashTable.get(artyomShootov.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 4 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i));
        }

        hashTable.put(janeRoe.getLastName(), janeRoe);
        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));
        assertEquals(janeRoe, hashTable.get(5));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 4 || i == 5 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i));
        }

        assertEquals(johnDoe, hashTable.remove(johnDoe.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 4 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i));
        }
        assertEquals(janeRoe, hashTable.get(3));
        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));
        assertEquals(alexKing, hashTable.get(4));
        assertEquals(alexKing, hashTable.get(alexKing.getLastName()));
        assertEquals(artyomShootov, hashTable.get(7));
        assertEquals(artyomShootov, hashTable.get(artyomShootov.getLastName()));

        assertEquals(alexKing, hashTable.remove(alexKing.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i));
        }
        assertEquals(janeRoe, hashTable.get(3));
        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));
        assertEquals(artyomShootov, hashTable.get(7));
        assertEquals(artyomShootov, hashTable.get(artyomShootov.getLastName()));

        assertEquals(artyomShootov, hashTable.remove(artyomShootov.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {

            if (i == 3) {
                continue;
            }

            assertNull(hashTable.get(i));
        }
        assertEquals(janeRoe, hashTable.get(3));
        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));

        assertEquals(janeRoe, hashTable.remove(janeRoe.getLastName()));
        for (int i = 0; i < hashTable.capacity(); i++) {
            assertNull(hashTable.get(i));
        }
    }
}