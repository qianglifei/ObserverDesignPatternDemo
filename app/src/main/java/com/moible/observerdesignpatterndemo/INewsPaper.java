package com.moible.observerdesignpatterndemo;
/**
 * 报纸接口
 * 抽象主题
 *
 */

public interface INewsPaper {
    //添加订阅者
    void addSubcriber(ISubScriber mSubScriber);
    //取消订阅
    void removeSubcriber(ISubScriber mSubScriber);
    //发送报纸
    void sendNewsPaper();
}
