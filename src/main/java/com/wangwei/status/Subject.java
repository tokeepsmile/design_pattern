package com.wangwei.status;

/**
 * @Autor wangwei
 * @Data 2021/5/24 18:01
 */
public interface Subject {

    void registerObserver(Observer observer);

    void remvoeObserver(Observer observer);

    void notifyObservers(Message message);
}
