package com.exer;

/**
 * @Autor wangwei
 * @Data 2021/5/27 15:07
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 100; i++) {
            array.addFirst(i);
        }
        System.out.println(array);

        array.remove(5);

        System.out.println(array);

        array.removeFirst();

        System.out.println(array);

        array.resort();

        System.out.println(array);
    }
}
