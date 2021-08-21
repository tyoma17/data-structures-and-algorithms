package com.tyoma17.data_structures.list.doubly_linked_list;

import com.tyoma17.data_structures.Person;
import lombok.extern.log4j.Log4j2;

import java.util.Iterator;
import java.util.LinkedList;

@Log4j2
public class JdkLinkedListClient {

    public static void main(String[] args) {

        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");

        LinkedList<Person> persons = new LinkedList<>();
        persons.addFirst(johnDoe);
        persons.addLast(richardRoe);
        persons.addFirst(janeRoe);
        persons.addLast(babyDoe);

        log.info("HEAD");
        log.info("↓");
        Iterator<Person> iterator = persons.iterator();

        while (iterator.hasNext()) {
            log.info(iterator.next());
            log.info("↕");
        }
        log.info("null");
    }
}