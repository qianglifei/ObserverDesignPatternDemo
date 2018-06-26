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
//    你只要弄明白单例模式是如何实现的，就能从本质上理解这个问题；
//    单例模式实现过程如下：
//    首先，将该类的构造函数私有化（目的是禁止其他程序创建该类的对象）；
//    其次，在本类中自定义一个对象（既然禁止其他程序创建该类的对象，就要自己创建一个供程序使用，否则类就没法用，更不是单例）；
//    最后，提供一个可访问类自定义对象的类成员方法（对外提供该对象的访问方式）。
//    直白的讲就是，你不能用该类在其他地方创建对象，而是通过该类自身提供的方法访问类中的那个自定义对象。
//    那么问题的关键来了，程序调用类中方法只有两种方式，①创建类的一个对象，用该对象去调用类中方法；②使用类名直接调用类中方法，格式“类名.方法名()”；
//    上面说了，构造函数私有化后第一种情况就不能用，只能使用第二种方法。
//    而使用类名直接调用类中方法，类中方法必须是静态的，而静态方法不能访问非静态成员变量，因此类自定义的实例变量也必须是静态的。
//    这就是单例模式唯一实例必须设置为静态的原因。
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
