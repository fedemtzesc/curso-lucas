package com.spring.boot.curso.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JSONClass {
    private String name;
    private String last;
    private int age;
}
