package com.tyoma17.data_structures.list.doubly_linked_list;

import com.tyoma17.data_structures.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListClientIT {

    @Test
    void testDoublyLinkedList() {
        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");

        DoublyLinkedList<Person> persons = new DoublyLinkedList<>();
        assertTrue(persons.isEmpty());
        persons.addToFront(johnDoe);
        assertEquals(persons.getHead(), persons.getTail());
        Node<Person> johnDoeNode = persons.getHead();
        assertNull(johnDoeNode.getNext());
        assertNull(johnDoeNode.getPrevious());
        assertEquals(1, persons.getSize());


        persons.addToEnd(richardRoe);
        assertEquals(johnDoeNode, persons.getHead());
        Node<Person> richardRoeNode = persons.getTail();
        assertEquals(richardRoeNode, johnDoeNode.getNext());
        assertNull(johnDoeNode.getPrevious());
        assertNull(richardRoeNode.getNext());
        assertEquals(johnDoeNode, richardRoeNode.getPrevious());
        assertEquals(2, persons.getSize());

        persons.addToFront(janeRoe);
        Node<Person> janeRoeNode = persons.getHead();
        assertNull(janeRoeNode.getPrevious());
        assertEquals(johnDoeNode, janeRoeNode.getNext());

        persons.addToEnd(babyDoe);
        Node<Person> babyDoeNode = persons.getTail();
        assertNull(babyDoeNode.getNext());
        assertEquals(richardRoeNode, babyDoeNode.getPrevious());

        assertEquals(4, persons.getSize());

        persons.removeFromFont();
        assertEquals(johnDoeNode, persons.getHead());
        assertNull(johnDoeNode.getPrevious());
        assertEquals(richardRoeNode, johnDoeNode.getNext());
        assertEquals(3, persons.getSize());

        persons.removeFromEnd();
        assertEquals(richardRoeNode, persons.getTail());
        assertNull(richardRoeNode.getNext());
        assertEquals(johnDoeNode, richardRoeNode.getPrevious());
        assertEquals(2, persons.getSize());

        Person johnnyRoe = new Person(5, "Johnny", "Roe");
        persons.addBefore(johnnyRoe, richardRoe);
        Node<Person> johnnyRoeNode = persons.getTail().getPrevious();
        assertEquals(johnnyRoeNode, johnDoeNode.getNext());
        assertEquals(johnDoeNode, johnnyRoeNode.getPrevious());
        assertEquals(richardRoeNode, johnnyRoeNode.getNext());
        assertEquals(3, persons.getSize());

        Person johnSmith = new Person(6, "John", "Smith");
        persons.addBefore(johnSmith, johnDoe);
        Node<Person> johnSmithNode = persons.getHead();
        assertEquals(johnSmithNode, johnDoeNode.getPrevious());
        assertNull(johnSmithNode.getPrevious());
        assertEquals(johnDoeNode, johnSmithNode.getNext());
        assertEquals(johnnyRoeNode, johnDoeNode.getNext());
        assertEquals(4, persons.getSize());
    }
}