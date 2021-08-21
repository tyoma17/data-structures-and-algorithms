package com.tyoma17.data_structures.list.linked_list;

import com.tyoma17.data_structures.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListClientIT {

    @Test
    void testLinkedList() {
        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");

        LinkedList<Person> persons = new LinkedList<>();
        assertTrue(persons.isEmpty());
        assertEquals(0, persons.getSize());

        persons.addToFront(johnDoe);
        Node<Person> johnDoeNode = persons.getHead();
        assertEquals(johnDoeNode.getElement(), johnDoe);
        assertNull(johnDoeNode.getNext());
        assertEquals(1, persons.getSize());

        persons.addToFront(richardRoe);
        Node<Person> richardRoeNode = persons.getHead();
        assertEquals(richardRoeNode.getElement(), richardRoe);
        assertEquals(richardRoeNode.getNext(), johnDoeNode);
        assertEquals(2, persons.getSize());

        persons.addToFront(janeRoe);
        Node<Person> janeRoeNode = persons.getHead();
        assertEquals(janeRoeNode.getElement(), janeRoe);
        assertEquals(janeRoeNode.getNext(), richardRoeNode);

        assertFalse(persons.isEmpty());
        assertEquals(3, persons.getSize());

        persons.removeFromFont();
        assertFalse(persons.isEmpty());
        assertEquals(2, persons.getSize());
    }

}