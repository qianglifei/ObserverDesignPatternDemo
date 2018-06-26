package com.moible.observerdesignpatterndemo;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {



    /**
     * 用来保存注册者观察对象
     */
    private List<ObserverListener> mList = new ArrayList<>();

    /**
     * 注册观察者对象
     * @param observerListener
     */
    public void attach(ObserverListener observerListener){
        mList.add(observerListener);
        System.out.println("Attached an observer");
    }

    /**
     * 删除观察者
     */
    public void detach(ObserverListener observerListener){
        mList.remove(observerListener);
    }

    /**
     *通知所有观察者
     */
    public void notifyObservers(String str){
        for (int i = 0; i < mList.size(); i++) {
            mList.get(i).updateData(str);
        }
    }
}
