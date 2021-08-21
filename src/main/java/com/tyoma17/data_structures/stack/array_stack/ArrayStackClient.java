package com.tyoma17.data_structures.stack.array_stack;

import com.tyoma17.data_structures.Person;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ArrayStackClient {

    public static void main(String[] args) {

        Person johnDoe = new Person(1, "John", "Doe");
        Person richardRoe = new Person(2, "Richard", "Roe");
        Person janeRoe = new Person(3, "Jane", "Roe");
        Person babyDoe = new Person(4, "Baby", "Doe");
        Person johnnyRoe = new Person(5, "Johnny", "Roe");
        Person johnSmith = new Person(6, "John", "Smith");

        log.info("Creating stack of persons...");
        ArrayStack<Person> stack = new ArrayStack<>(Person.class, 2);
        log.info(stack.stackAsString());

        log.info("Pushing {} to stack...", johnDoe);
        stack.push(johnDoe);
        log.info(stack.stackAsString());

        log.info("Pushing {} to stack...", richardRoe);
        stack.push(richardRoe);
        log.info(stack.stackAsString());

        log.info("Pushing {} to stack...", janeRoe);
        stack.push(janeRoe);
        log.info(stack.stackAsString());

        log.info("Pushing {} to stack...", babyDoe);
        stack.push(babyDoe);
        log.info(stack.stackAsString());

        log.info("Pushing {} to stack...", johnnyRoe);
        stack.push(johnnyRoe);
        log.info(stack.stackAsString());

        log.info("Pushing {} to stack...", johnSmith);
        stack.push(johnSmith);
        log.info(stack.stackAsString());

        log.info("Peeking from stack...");
        Person peekedPerson = stack.peek();
        log.info("Peeked person: {}", peekedPerson);

        while (!stack.isEmpty()) {
            log.info("Popping from stack...");
            Person poppedPerson = stack.pop();
            log.info(stack.stackAsString());
            log.info("Popped person: {}", poppedPerson);
        }
    }
}