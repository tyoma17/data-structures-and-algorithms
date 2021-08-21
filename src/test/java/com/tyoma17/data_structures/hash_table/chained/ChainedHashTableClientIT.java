package com.tyoma17.data_structures.hash_table.chained;

import com.tyoma17.data_structures.Person;
import com.tyoma17.data_structures.hash_table.StoredElement;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ChainedHashTableClientIT {

    @Test
    void testChainedHashTable() {

        Person johnDoe = new Person(1, "John", "Doe");
        Person artyomShootov = new Person(2, "Artyom", "Shootov");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person alexKing = new Person(5, "Alex", "King");

        ChainedHashTable<Person> hashTable = new ChainedHashTable<>();
        assertEquals(10, hashTable.keysCapacity());
        for (int i = 0; i < hashTable.keysCapacity(); i++) {
            assertNull(hashTable.get(i).peek());
        }

        hashTable.put(johnDoe.getLastName(), johnDoe);
        assertEquals(johnDoe, hashTable.get(johnDoe.getLastName()));
        for (int i = 0; i < hashTable.keysCapacity(); i++) {

            if (i == 3) {
                continue;
            }

            assertNull(hashTable.get(i).peek());
        }

        hashTable.put(alexKing.getLastName(), alexKing);
        assertEquals(alexKing, hashTable.get(alexKing.getLastName()));
        for (int i = 0; i < hashTable.keysCapacity(); i++) {

            if (i == 3 || i == 4) {
                continue;
            }

            assertNull(hashTable.get(i).peek());
        }

        hashTable.put(artyomShootov.getLastName(), artyomShootov);
        assertEquals(artyomShootov, hashTable.get(artyomShootov.getLastName()));
        for (int i = 0; i < hashTable.keysCapacity(); i++) {

            if (i == 3 || i == 4 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i).peek());
        }

        hashTable.put(janeRoe.getLastName(), janeRoe);
        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));
        LinkedList<StoredElement<Person>> surnamesOfLength3 = hashTable.get(3);
        Iterator<StoredElement<Person>> iterator = surnamesOfLength3.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (index == 0) {
                assertEquals(johnDoe, iterator.next().getElement());
            } else if (index == 1) {
                assertEquals(janeRoe, iterator.next().getElement());
            } else {
                fail();
            }
            index++;
        }
        for (int i = 0; i < hashTable.keysCapacity(); i++) {

            if (i == 3 || i == 4 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i).peek());
        }

        assertEquals(johnDoe, hashTable.remove(johnDoe.getLastName()));
        for (int i = 0; i < hashTable.keysCapacity(); i++) {

            if (i == 3 || i == 4 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i).peek());
        }

        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));
        assertEquals(alexKing, hashTable.get(alexKing.getLastName()));
        assertEquals(artyomShootov, hashTable.get(artyomShootov.getLastName()));

        assertEquals(alexKing, hashTable.remove(alexKing.getLastName()));
        for (int i = 0; i < hashTable.keysCapacity(); i++) {

            if (i == 3 || i == 7) {
                continue;
            }

            assertNull(hashTable.get(i).peek());
        }
        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));
        assertEquals(artyomShootov, hashTable.get(artyomShootov.getLastName()));

        assertEquals(artyomShootov, hashTable.remove(artyomShootov.getLastName()));
        for (int i = 0; i < hashTable.keysCapacity(); i++) {

            if (i == 3) {
                continue;
            }

            assertNull(hashTable.get(i).peek());
        }
        assertEquals(janeRoe, hashTable.get(janeRoe.getLastName()));

        assertEquals(janeRoe, hashTable.remove(janeRoe.getLastName()));
        for (int i = 0; i < hashTable.keysCapacity(); i++) {
            assertNull(hashTable.get(i).peek());
        }
    }

}