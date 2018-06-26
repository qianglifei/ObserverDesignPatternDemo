package com.moible.observerdesignpatterndemo;

/**
 * 具体观察者
 */
public class ConcreteObserver implements ObserverListener  {
    //观察者状态
    private String observerState;
    @Override
    public void updateData(String content) {
        observerState = content;
        System.out.println("状态为："+observerState);
    }
}
