package com.wangwei.status;

/**
 * @Autor wangwei
 * @Data 2021/5/24 18:08
 */
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo is notify");
    }
}
