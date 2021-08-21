package com.tyoma17.data_structures;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
}