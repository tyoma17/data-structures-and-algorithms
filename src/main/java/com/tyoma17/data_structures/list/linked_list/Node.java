package com.tyoma17.data_structures.list.linked_list;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Node<E> {

    private E element;
    private Node<E> next;

    public Node(E e) {
        this.element = e;
    }
}