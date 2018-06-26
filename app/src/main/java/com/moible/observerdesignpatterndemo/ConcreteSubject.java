package com.moible.observerdesignpatterndemo;

import android.util.Log;

public class ConcreteSubject extends Subject {
    private static ConcreteSubject mConcreteSubject;
    //单例模式
    public static ConcreteSubject getInstance(){
        if (null == mConcreteSubject){
            //同步锁
            synchronized (ConcreteSubject.class){
                if (null == mConcreteSubject){
                    mConcreteSubject = new ConcreteSubject();
                }
            }
        }
        return mConcreteSubject;
    }

    //观察者状态
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        Log.i("TAG", "主题状态为: " + state);
        //状态发生改变，通知各个观察者
        this.notifyObservers(state);
    }
}
