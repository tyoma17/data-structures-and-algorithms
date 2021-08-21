package com.tyoma17.data_structures.list.linked_list;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public void addToFront(E e) {
        log.debug("Adding {} to the front of linked list", e);
        Node<E> node = new Node<>(e);
        log.debug("Setting next element of {} to head ({})", node, head);
        node.setNext(head);
        log.debug("{}", node);
        log.debug("Setting head of the linked list to {}", node);
        head = node;
        log.debug("Incrementing size of the linked list");
        size++;
        log.debug("Size is {}", size);
    }

    public Node<E> removeFromFont() {

        if (isEmpty()) {
            return null;
        }

        Node<E> removedNote = head;
        log.debug("Removing head from the front of linked list: {}", head);
        log.debug("Setting head of the linked list to next value of current head: {}", head.getNext());
        head = head.getNext();
        log.debug("Decrementing size of the linked list");
        size--;
        log.debug("Size is {}", size);
        log.debug("Removing reference for next node from the removed one");
        removedNote.setNext(null);

        return removedNote;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String linkedListAsString() {

        StringBuilder stringBuilder = new StringBuilder("\n-------- LINKED LIST --------\n");
        stringBuilder.append("HEAD\n");
        stringBuilder.append("↓\n");

        Node<E> current = head;

        while (current != null) {
            stringBuilder.append(current.getElement() + "\n");
            stringBuilder.append("↓\n");
            current = current.getNext();
        }

        stringBuilder.append("null\n");
        stringBuilder.append("-------- LINKED LIST --------");

        return stringBuilder.toString();
    }
}