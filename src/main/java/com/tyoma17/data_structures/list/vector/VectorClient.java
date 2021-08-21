package com.tyoma17.data_structures.list.vector;

import com.tyoma17.data_structures.Person;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Vector;

@Log4j2
public class VectorClient {

    public static void main(String[] args) {

        List<Person> persons = new Vector<>(); // Vector is synchronized version of ArrayList
        persons.add(new Person(1, "John", "Doe"));
        persons.add(new Person(2, "Richard", "Roe"));
        persons.add(new Person(3, "Jane", "Roe"));

        Person[] people = persons.toArray(new Person[0]);
//        https://stackoverflow.com/a/4042464/12943499
//        https://stackoverflow.com/a/9572820/12943499
//        Person[] people = persons.toArray(new Person[persons.size()]);

        for (Person person : people) {
            log.info(person);
        }
    }
}