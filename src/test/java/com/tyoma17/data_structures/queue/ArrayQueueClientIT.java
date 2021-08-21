package com.tyoma17.data_structures.queue;

import com.tyoma17.data_structures.Person;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayQueueClientIT {

    @Test
    void testArrayQueue() {
        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");
        Person johnnyRoe = new Person(5, "Johnny", "Roe");
        Person johnSmith = new Person(6, "John", "Smith");

        ArrayQueue<Person> queue = new ArrayQueue<>(Person.class, 2);
        assertEquals(0, queue.size());
        assertEquals(2, queue.capacity());
        assertEquals(0, queue.frontElementIndex());
        assertEquals(0, queue.toBeAddedElementIndex());
        assertThrows(NoSuchElementException.class, () -> queue.peek());

        queue.add(johnDoe);
        assertEquals(1, queue.size());
        assertEquals(2, queue.capacity());
        assertEquals(0, queue.frontElementIndex());
        assertEquals(1, queue.toBeAddedElementIndex());
        assertEquals(johnDoe, queue.peek());

        queue.add(richardRoe);
        assertEquals(2, queue.size());
        assertEquals(4, queue.capacity());
        assertEquals(0, queue.frontElementIndex());
        assertEquals(2, queue.toBeAddedElementIndex());
        assertEquals(johnDoe, queue.peek());

        Person removedPerson = queue.remove();
        assertEquals(1, queue.size());
        assertEquals(4, queue.capacity());
        assertEquals(1, queue.frontElementIndex());
        assertEquals(2, queue.toBeAddedElementIndex());
        assertEquals(johnDoe, removedPerson);
        assertEquals(richardRoe, queue.peek());

        queue.add(janeRoe);
        assertEquals(2, queue.size());
        assertEquals(4, queue.capacity());
        assertEquals(1, queue.frontElementIndex());
        assertEquals(3, queue.toBeAddedElementIndex());
        assertEquals(richardRoe, queue.peek());

        queue.add(babyDoe);
        assertEquals(3, queue.size());
        assertEquals(4, queue.capacity());
        assertEquals(1, queue.frontElementIndex());
        assertEquals(0, queue.toBeAddedElementIndex());
        assertEquals(richardRoe, queue.peek());

        removedPerson = queue.remove();
        assertEquals(2, queue.size());
        assertEquals(4, queue.capacity());
        assertEquals(2, queue.frontElementIndex());
        assertEquals(0, queue.toBeAddedElementIndex());
        assertEquals(richardRoe, removedPerson);
        assertEquals(janeRoe, queue.peek());

        queue.add(johnnyRoe);
        assertEquals(3, queue.size());
        assertEquals(4, queue.capacity());
        assertEquals(2, queue.frontElementIndex());
        assertEquals(1, queue.toBeAddedElementIndex());
        assertEquals(janeRoe, queue.peek());

        queue.add(johnSmith);
        assertEquals(4, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(0, queue.frontElementIndex());
        assertEquals(4, queue.toBeAddedElementIndex());
        assertEquals(janeRoe, queue.peek());

        queue.add(johnDoe);
        assertEquals(5, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(0, queue.frontElementIndex());
        assertEquals(5, queue.toBeAddedElementIndex());
        assertEquals(janeRoe, queue.peek());

        queue.add(richardRoe);
        assertEquals(6, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(0, queue.frontElementIndex());
        assertEquals(6, queue.toBeAddedElementIndex());
        assertEquals(janeRoe, queue.peek());

        removedPerson = queue.remove();
        assertEquals(5, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(1, queue.frontElementIndex());
        assertEquals(6, queue.toBeAddedElementIndex());
        assertEquals(janeRoe, removedPerson);
        assertEquals(babyDoe, queue.peek());

        removedPerson = queue.remove();
        assertEquals(4, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(2, queue.frontElementIndex());
        assertEquals(6, queue.toBeAddedElementIndex());
        assertEquals(babyDoe, removedPerson);
        assertEquals(johnnyRoe, queue.peek());

        removedPerson = queue.remove();
        assertEquals(3, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(3, queue.frontElementIndex());
        assertEquals(6, queue.toBeAddedElementIndex());
        assertEquals(johnnyRoe, removedPerson);
        assertEquals(johnSmith, queue.peek());

        removedPerson = queue.remove();
        assertEquals(2, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(4, queue.frontElementIndex());
        assertEquals(6, queue.toBeAddedElementIndex());
        assertEquals(johnSmith, removedPerson);
        assertEquals(johnDoe, queue.peek());

        removedPerson = queue.remove();
        assertEquals(1, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(5, queue.frontElementIndex());
        assertEquals(6, queue.toBeAddedElementIndex());
        assertEquals(johnDoe, removedPerson);
        assertEquals(richardRoe, queue.peek());

        removedPerson = queue.remove();
        assertEquals(0, queue.size());
        assertEquals(8, queue.capacity());
        assertEquals(0, queue.frontElementIndex());
        assertEquals(0, queue.toBeAddedElementIndex());
        assertEquals(richardRoe, removedPerson);
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }
}