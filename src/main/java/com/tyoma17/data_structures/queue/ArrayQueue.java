package com.tyoma17.data_structures.queue;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

@Log4j2
public class ArrayQueue<E> { // queue backed by an array

    private E[] queue;
    private int front;
    private int back; // actually it's index of to be added element. implementation can be improved
    private final Class<E> clazz;

    public ArrayQueue(Class<E> clazz, int capacity) {
        log.debug("Creating a {} queue of capacity = {}...", clazz.getSimpleName(), capacity);
        queue = (E[]) Array.newInstance(clazz, capacity);
        log.debug("The queue has been initialized");
        this.clazz = clazz;
    }

    public void add(E element) {

        log.debug("Adding {} to queue...", element);
        int numItems = size();

        if (numItems == queue.length - 1) {
            log.debug("Queue is full: {} objects", numItems);
            log.debug("Resizing the backing array...");
            E[] newArray = (E[]) Array.newInstance(clazz, queue.length * 2);
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;
            log.debug("The backing array has been resized. New size = {}", queue.length);
            front = 0;
            log.debug("The front of the queue is at index: {}", front);
            back = numItems;
            log.debug("The back of the queue is at index: {}", back);
        }

        log.debug("Assigning {} to the back (index = {}) of the queue", element, back);
        queue[back] = element;

        if (back < queue.length - 1) {
            back++;
        } else { // circular queue
            back = 0;
        }

        log.debug("The back of the queue is at index: {}", back);
        log.debug("Successfully added {} to queue", element);
    }

    public E remove() {

        log.debug("Removing from queue...");

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E element = queue[front];
        log.debug("Removing {} from the front (index = {}) of the queue", element, front);
        queue[front] = null;
        front++;

        if (isEmpty()) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }

        log.debug("Successfully removed {} from queue", element);
        return element;
    }

    public E peek() {
        log.debug("Peeking from queue...");
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        log.debug("Successfully peeked");
        return queue[front];
    }

    public boolean isEmpty() {
        return back - front == 0;
    }

    public int size() {
        if (front <= back) { // queue has not wrapped
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public String queueAsString() {

        StringBuilder stringBuilder = new StringBuilder("\n-------- QUEUE --------\n");

        if (front <= back) { // queue has not wrapped

            for (int i = front; i < back; i++) {
                stringBuilder.append(queue[i] + "\n");
            }

        } else {

            for (int i = front; i < queue.length; i++) {
                stringBuilder.append(queue[i]);
            }

            for (int i = 0; i < back; i++) {
                stringBuilder.append(queue[i]);
            }
        }


        stringBuilder.append("-------- QUEUE --------");

        return stringBuilder.toString();
    }

    public int capacity() {
        return queue.length;
    }

    public int frontElementIndex() {
        return front;
    }

    public int toBeAddedElementIndex() {
        return back;
    }
}