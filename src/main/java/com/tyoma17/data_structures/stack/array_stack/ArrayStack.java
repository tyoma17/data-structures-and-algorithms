package com.tyoma17.data_structures.stack.array_stack;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

@Log4j2
public class ArrayStack<E> { // stack backed by an array

    private final Class<E> clazz;
    private E[] stack;
    private int top;

    public ArrayStack(Class<E> clazz, int capacity) {
        log.debug("Creating a {} array of capacity = {}...", clazz.getSimpleName(), capacity);
        stack = (E[]) Array.newInstance(clazz, capacity);
        log.debug("The array has been initialized");
        this.clazz = clazz;
    }

    public void push(E element) {

        log.debug("Pushing {} to stack...", element);

        if (top == stack.length) {

            log.debug("Stack is full: {} objects", stack.length);
            log.debug("Resizing the backing array...");
            E[] newArray = (E[]) Array.newInstance(clazz, stack.length * 2);
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
            log.debug("The backing array has been resized. New size = {}", stack.length);

        }

        stack[top++] = element;
    }

    public E pop() {

        log.debug("Popping from the stack...");

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E element = stack[--top];
        stack[top] = null;

        if (top != 0 && stack.length / top == 2) {

            log.debug("Only a half of backed array is being used. Resizing it...");
            E[] newArray = (E[]) Array.newInstance(clazz, stack.length / 2);
            System.arraycopy(stack, 0, newArray, 0, newArray.length);
            stack = newArray;
            log.debug("The backing array has been resized. New size = {}", stack.length);

        }

        log.debug("Successfully popped from the stack");
        return element;
    }

    public E peek() {
        log.debug("Peeking from the stack...");
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        log.debug("Successfully peeked");
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public String stackAsString() {

        StringBuilder stringBuilder = new StringBuilder("\n-------- STACK --------\n");

        for (int i = top - 1; i >= 0; i--) {
            stringBuilder.append(stack[i] + "\n");
        }

        stringBuilder.append("-------- STACK --------");

        return stringBuilder.toString();
    }

    public int capacity() {
        return stack.length;
    }
}