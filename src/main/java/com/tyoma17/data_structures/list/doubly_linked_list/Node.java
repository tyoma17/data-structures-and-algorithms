package com.tyoma17.data_structures.list.doubly_linked_list;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<E> {

    private E element;
    private Node<E> next;
    private Node<E> previous;

    public Node(E e) {
        this.element = e;
    }

    @Override
    public String toString() {
        E nextElement = next == null ? null : next.getElement();
        E previousElement = previous == null ? null : previous.getElement();
        return "Node{" +
                "element=" + element +
                ", next=" + nextElement +
                ", previous=" + previousElement +
                '}';
    }
}