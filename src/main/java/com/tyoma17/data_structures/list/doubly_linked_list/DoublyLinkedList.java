package com.tyoma17.data_structures.list.doubly_linked_list;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void addToFront(E e) {
        log.debug("Adding {} to the front of doubly linked list", e);
        Node<E> node = new Node<>(e);

        if (head == null) {
            log.debug("Head is null. Setting tail to {}", node);
            tail = node;
        } else {
            log.debug("Setting previous node of current head to the new node");
            head.setPrevious(node);
            log.debug(head);
            log.debug("Setting next element of {} to head ({})", node, head);
            node.setNext(head);
        }

        log.debug("Setting head to the new node");
        head = node;
        log.debug("Incrementing size of the linked list");
        size++;
        log.debug("Size is {}", size);
    }

    public boolean addBefore(E newElement, E existingElement) {

        log.debug("Adding {} before {}", newElement, existingElement);

        if (head == null) {
            log.debug("Doubly linked list is empty. New element will not be added");
            return false;
        }

        Node<E> existingElementNode = findNodeOfExistingElement(existingElement);

        if (existingElementNode == null) {
            log.debug("New element will not be added since no node has been found for existing element");
            return false;
        }

        Node<E> newNode = new Node<>(newElement);
        log.debug("Setting previous node of new node to previous node of existing node");
        newNode.setPrevious(existingElementNode.getPrevious());
        log.debug("newNode.previous = {}", existingElementNode.getPrevious());
        log.debug("Setting next node of new node to the existing node");
        newNode.setNext(existingElementNode);
        log.debug("newNode.next = {}", existingElementNode);
        log.debug("Setting previous node of existing element to new node");
        existingElementNode.setPrevious(newNode);
        log.debug("existingnNode.previous = {}", newNode);

        if (head == existingElementNode) {
            head = newNode;
            log.debug("Existing node was the head of linked list, so new node has become the head");
        } else {
            log.debug("Setting next node of new node's previous node to new node");
            newNode.getPrevious().setNext(newNode);
        }

        log.debug("Incrementing the size of linked list");
        size++;
        log.debug("Size of linked list is {}", size);

        return true;
    }

    public Node<E> findNodeOfExistingElement(E existingElement) {

        log.debug("Searching for node of {}", existingElement);

        Node<E> currentNode = head;

        while (currentNode != null && !currentNode.getElement().equals(existingElement)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode == null || !currentNode.getElement().equals(existingElement)) {
            log.debug("Node has not been found");
            return null;
        } else {
            log.debug("Node has been found: {}", currentNode);
            return currentNode;
        }
    }

    public void addToEnd(E e) {
        log.debug("Adding {} to the end of doubly linked list", e);
        Node<E> node = new Node<>(e);

        if (tail == null) {
            log.debug("Tail is null. Setting head to {}", node);
            head = node;
        } else {
            log.debug("Setting next node of current tail to the new node");
            tail.setNext(node);
            log.debug(tail);
            log.debug("Setting previous element of {} to tail ({})", node, tail);
            node.setPrevious(tail);
        }

        log.debug("Setting tail to the new node");
        tail = node;
        log.debug("Incrementing size of the doubly linked list");
        size++;
        log.debug("Size is {}", size);
    }

    public Node<E> removeFromFont() {

        if (isEmpty()) {
            return null;
        }

        Node<E> removedNote = head;
        log.debug("Removing head from the front of linked list: {}", head);

        if (head.getNext() == null) {
            log.debug("Next node of current head is null, so is tail");
            tail = null;
        } else {
            log.debug("Setting previous node of head's next node to null");
            head.getNext().setPrevious(null);
            log.debug(head.getNext());
        }

        log.debug("Setting head to current head's next node");
        head = head.getNext();
        log.debug("Decrementing size of the doubly linked list");
        size--;
        log.debug("Size is {}", size);
        log.debug("Removing reference for next and previous nodes from the removed one");
        removedNote.setNext(null);
        removedNote.setPrevious(null);

        return removedNote;
    }

    public Node<E> removeFromEnd() {

        if (isEmpty()) {
            return null;
        }

        Node<E> removedNote = tail;
        log.debug("Removing tail from the end of linked list: {}", tail);

        if (tail.getPrevious() == null) {
            log.debug("Previous node of current tail is null, so is head");
            head = null;
        } else {
            log.debug("Setting next node of tail's previous node to null");
            tail.getPrevious().setNext(null);
        }

        log.debug("Setting tail to current tails's previous node");
        tail = tail.getPrevious();
        log.debug("Decrementing size of the doubly linked list");
        size--;
        log.debug("Size is {}", size);
        log.debug("Removing reference for next and previous nodes from the removed one");
        removedNote.setPrevious(null);
        removedNote.setNext(null);

        return removedNote;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void logList() {
        log.info("-------- LINKED LIST --------");
        Node<E> current = head;
        log.info("HEAD");
        log.info("↓");

        while (current != null) {
            log.info(current.getElement());
            log.info("↕");
            current = current.getNext();
        }

        log.info("null");
        log.info("-------- LINKED LIST --------");
    }
}