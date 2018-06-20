package com.moible.observerdesignpatterndemo;

/**
 * 观察者，需要实现观察者模式的类，需实现此接口
 */
public interface ObserverListener {
    void updateData(String content);
}
