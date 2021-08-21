package com.tyoma17.data_structures.list.doubly_linked_list;

import com.tyoma17.data_structures.Person;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DoublyLinkedListClient {

    public static void main(String[] args) {

        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");

        DoublyLinkedList<Person> persons = new DoublyLinkedList<>();
        persons.logList();
        persons.addToFront(johnDoe);
        persons.logList();
        persons.addToEnd(richardRoe);
        persons.logList();
        persons.addToFront(janeRoe);
        persons.logList();
        persons.addToEnd(babyDoe);

        log.info("Doubly linked list is{}empty", persons.isEmpty() ? " " : " not ");
        log.info("Doubly linked list contains of {} persons:", persons.getSize());
        persons.logList();

        log.info("Removing one person from the the front of the list...");
        persons.removeFromFont();
        persons.logList();
        log.info("Removing one person from the the end of the list...");
        persons.removeFromEnd();
        log.info("Doubly linked list contains of {} persons:", persons.getSize());
        persons.logList();

        Person johnnyRoe = new Person(5, "Johnny", "Roe");
        persons.addBefore(johnnyRoe, richardRoe);
        log.info("Doubly linked list contains of {} persons:", persons.getSize());
        persons.logList();
    }
}