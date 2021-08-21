package com.tyoma17.data_structures.stack.linked_stack;

import com.tyoma17.data_structures.list.linked_list.LinkedList;
import com.tyoma17.data_structures.list.linked_list.Node;
import lombok.extern.log4j.Log4j2;

import java.util.EmptyStackException;

@Log4j2
public class LinkedStack<E> {

    private LinkedList<E> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    public void push(E element) {
        log.debug("Pushing {} to stack...", element);
        stack.addToFront(element);
        log.debug("Successfully pushed");
    }

    public E pop() {

        log.debug("Popping from the stack...");

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        log.debug("Successfully popped from the stack");
        return stack.removeFromFont().getElement();
    }

    public E peek() {

        log.debug("Peeking from the stack...");

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        log.debug("Successfully peeked");
        return stack.getHead().getElement();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String stackAsString() {

        StringBuilder stringBuilder = new StringBuilder("\n-------- STACK --------\n");

        Node<E> currentNode = stack.getHead();

        while (currentNode != null) {
            stringBuilder.append(currentNode.getElement() + "\n");
            currentNode = currentNode.getNext();
        }

        stringBuilder.append("-------- STACK --------");

        return stringBuilder.toString();
    }

    public int size() {
        return stack.getSize();
    }
}