package com.exer;

import org.apache.ibatis.reflection.Reflector;

/**
 * @Autor wangwei
 * @Data 2021/5/27 16:07
 */
public class RelfectorDemo {
    public static void main(String[] args) {
        Reflector reflector = new Reflector(Person.class);
    }
}
