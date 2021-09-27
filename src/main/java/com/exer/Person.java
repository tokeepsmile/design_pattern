package com.exer;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Autor wangwei
 * @Data 2021/5/27 16:05
 */
@Data
public class Person {
    private String name;

    private Integer age;

    private BigDecimal balance;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }
}
