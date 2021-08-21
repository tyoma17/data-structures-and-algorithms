package com.tyoma17.data_structures.list.doubly_linked_list;

import com.tyoma17.data_structures.Person;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JdkLinkedListClientIT {

    @Test
    void testJdkLinkedList() {

        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");

        LinkedList<Person> persons = new LinkedList<>();
        assertTrue(persons.isEmpty());
        persons.addFirst(johnDoe);
        assertEquals(persons.getFirst(), persons.getLast());
        assertEquals(1, persons.size());

        persons.addLast(richardRoe);
        assertEquals(persons.getLast(), richardRoe);
        assertEquals(2, persons.size());

        persons.addFirst(janeRoe);
        assertEquals(persons.getFirst(), janeRoe);
        assertEquals(3, persons.size());

        persons.addLast(babyDoe);
        assertEquals(persons.getLast(), babyDoe);
        assertEquals(4, persons.size());

        persons.removeLast();
        assertEquals(richardRoe, persons.getLast());
        assertEquals(3, persons.size());

        persons.removeFirst();
        assertEquals(johnDoe, persons.getFirst());
        assertEquals(2, persons.size());
    }
}