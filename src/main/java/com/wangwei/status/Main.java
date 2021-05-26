package com.wangwei.status;

import java.util.Random;

/**
 * @Autor wangwei
 * @Data 2021/5/24 18:07
 */
public class Main {
    public static void main(String[] args) {
        Observer o1 = new ConcreteObserverOne();
        Observer o2 = new ConcreteObserverTwo();
        Subject subject = new ConcreteSubject();
        subject.registerObserver(o1);
        subject.registerObserver(o2);
        subject.notifyObservers(new Message("wangwei"));
    }
}
