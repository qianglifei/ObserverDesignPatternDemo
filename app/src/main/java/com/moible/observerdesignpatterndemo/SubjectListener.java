package com.moible.observerdesignpatterndemo;

/**
 * 被观察这对象
 */
public interface SubjectListener {
    void add(ObserverListener observerListener);
    void notifyObserver(String content);
    void remove(ObserverListener observerListener);
}
