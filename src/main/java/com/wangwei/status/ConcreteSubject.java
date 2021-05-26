package com.wangwei.status;

import java.util.ArrayList;
import java.util.List;

/**
 * @Autor wangwei
 * @Data 2021/5/24 18:05
 */
public class ConcreteSubject implements Subject{

    private static final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remvoeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        observers.forEach(observer -> observer.update(message));
    }
}
