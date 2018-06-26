package com.moible.observerdesignpatterndemo;
//订阅者
public interface ISubScriber {
    //有新的报纸了，就会被执行通知
    void hasNewPager();
}
