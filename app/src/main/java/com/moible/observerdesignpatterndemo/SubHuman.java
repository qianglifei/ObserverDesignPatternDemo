package com.moible.observerdesignpatterndemo;

public class SubHuman implements ISubScriber{

    //订阅者姓名
    private String sName;

    public SubHuman(String sName) {
        this.sName = sName;
    }

    //订阅者有新报纸了
    @Override
    public void hasNewPager() {
        System.out.println(sName + "!! 有新的报纸了，请查收！");
    }

}
