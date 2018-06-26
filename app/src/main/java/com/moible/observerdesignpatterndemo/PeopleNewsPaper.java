package com.moible.observerdesignpatterndemo;

import java.util.ArrayList;
import java.util.List;

public class PeopleNewsPaper implements INewsPaper {
    private static PeopleNewsPaper mPeopleNewsPaper;
    private List<ISubScriber> mList = new ArrayList<>();

    public static PeopleNewsPaper getInstace(){
        if (null == mPeopleNewsPaper){
            synchronized (PeopleNewsPaper.class){
                if (null == mPeopleNewsPaper){
                    mPeopleNewsPaper = new PeopleNewsPaper();
                }
            }
        }
        return mPeopleNewsPaper;
    }

    //添加订阅者
    @Override
    public void addSubcriber(ISubScriber mSubScriber) {
        mList.add(mSubScriber);
    }
    //移除订阅者
    @Override
    public void removeSubcriber(ISubScriber mSubScriber) {
        mList.remove(mSubScriber);
    }
    //发报纸了。。。
    @Override
    public void sendNewsPaper() {
        for (ISubScriber mSubScriber : mList) {
            //订阅者有报纸了
            mSubScriber.hasNewPager();
        }
    }
}
