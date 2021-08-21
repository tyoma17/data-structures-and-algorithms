package com.tyoma17.data_structures.hash_table;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoredElement<E> {
    private String key;
    private E element;
}