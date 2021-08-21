package com.tyoma17.data_structures.stack.array_stack;

import com.tyoma17.data_structures.Person;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayStackClientIT {

    @Test
    void testArrayStack() {

        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");
        Person johnnyRoe = new Person(5, "Johnny", "Roe");
        Person johnSmith = new Person(6, "John", "Smith");

        ArrayStack<Person> stack = new ArrayStack<>(Person.class, 2);
        assertEquals(0, stack.size());
        assertEquals(2, stack.capacity());

        stack.push(johnDoe);
        assertEquals(1, stack.size());
        assertEquals(2, stack.capacity());

        stack.push(richardRoe);
        assertEquals(2, stack.size());
        assertEquals(2, stack.capacity());
        assertEquals(richardRoe, stack.peek());

        stack.push(janeRoe);
        assertEquals(3, stack.size());
        assertEquals(4, stack.capacity());
        assertEquals(janeRoe, stack.peek());

        stack.push(babyDoe);
        assertEquals(4, stack.size());
        assertEquals(4, stack.capacity());
        assertEquals(babyDoe, stack.peek());

        stack.push(johnnyRoe);
        assertEquals(5, stack.size());
        assertEquals(8, stack.capacity());
        assertEquals(johnnyRoe, stack.peek());

        stack.push(johnSmith);
        assertEquals(6, stack.size());
        assertEquals(8, stack.capacity());
        assertEquals(johnSmith, stack.peek());

        Person poppedPerson = stack.pop();
        assertEquals(5, stack.size());
        assertEquals(8, stack.capacity());
        assertEquals(johnSmith, poppedPerson);
        assertEquals(johnnyRoe, stack.peek());

        poppedPerson = stack.pop();
        assertEquals(4, stack.size());
        assertEquals(4, stack.capacity());
        assertEquals(johnnyRoe, poppedPerson);
        assertEquals(babyDoe, stack.peek());

        poppedPerson = stack.pop();
        assertEquals(3, stack.size());
        assertEquals(4, stack.capacity());
        assertEquals(babyDoe, poppedPerson);
        assertEquals(janeRoe, stack.peek());

        poppedPerson = stack.pop();
        assertEquals(2, stack.size());
        assertEquals(2, stack.capacity());
        assertEquals(janeRoe, poppedPerson);
        assertEquals(richardRoe, stack.peek());

        poppedPerson = stack.pop();
        assertEquals(1, stack.size());
        assertEquals(1, stack.capacity());
        assertEquals(richardRoe, poppedPerson);
        assertEquals(johnDoe, stack.peek());

        poppedPerson = stack.pop();
        assertEquals(0, stack.size());
        assertEquals(1, stack.capacity());
        assertEquals(johnDoe, poppedPerson);
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }
}