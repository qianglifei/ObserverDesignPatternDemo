package com.moible.observerdesignpatterndemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者管理类
 */
public class ObserverManager implements SubjectListener{
    private static ObserverManager mObserverManager;
    //观察者接口对象
    private List<ObserverListener> mList = new ArrayList<>();
    //单例模式
    public static ObserverManager getInstance(){
        if (null == mObserverManager){
            synchronized (ObserverManager.class){
                if (null == mObserverManager){
                    mObserverManager = new ObserverManager();
                }
            }
        }
        return  mObserverManager;
    }

    /**
     * 加入监听队列
     * @param observerListener
     */
    @Override
    public void add(ObserverListener observerListener) {
        mList.add(observerListener);
    }

    /**
     * 通知观察者刷新数据
     * @param content
     */
    @Override
    public void notifyObserver(String content) {
        for (ObserverListener observerListener: mList) {
            observerListener.updateData(content);
        }
    }

    /**
     * 监听队列移除
     * @param observerListener
     */
    @Override
    public void remove(ObserverListener observerListener) {
        if (mList.contains(observerListener)){
            mList.remove(observerListener);
        }
    }
}
