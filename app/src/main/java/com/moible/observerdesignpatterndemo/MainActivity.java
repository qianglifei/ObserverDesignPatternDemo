package com.moible.observerdesignpatterndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * 组成
 * 1.抽象主题（Subject）：它把所有观察者对象的引用保存在一个聚集里面，每一个主题都可以有任何数量的观察者。
 * 抽象主题提供一个接口可以增加和删除观察者对象。
 * 2.具体主题（ConcreteSubject）:将有关状态存取具体观察者对象；在具体主题内部状态改变时，给所有登记过的观察者发出通知
 * 3.抽象观察者（Observer）:为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
 * 4.具体观察者（ConcreteObserver）:实现抽象观察者角色所要求的更新，以便使本身的状态与主题状态协调
 */
public class MainActivity extends AppCompatActivity  {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //初始化View
//        initView();
//        //初始化事件
//        initEvent();
          //创建主题对象
//        ConcreteSubject subject = ConcreteSubject.getInstance();
//        //创建观察者对象
//        ObserverListener observer1 = new ConcreteObserver();
//
//        //将观察者对象登记到主题对象上
//        subject.attach(observer1);
//
//        //改变主题对象的状态
//        subject.change("new state");

        PeopleNewsPaper peopleNewsPaper = PeopleNewsPaper.getInstace();

        SubHuman _xiaoming = new SubHuman("小明");
        SubHuman _xiaoguang = new SubHuman("小光");
        SubHuman _liminghan = new SubHuman("李明翰");
        peopleNewsPaper.addSubcriber(_xiaoming);
        peopleNewsPaper.addSubcriber(_xiaoguang);
        peopleNewsPaper.addSubcriber(_liminghan);
        //发送新报纸了
        peopleNewsPaper.sendNewsPaper();
        System.out.println("---------------发完报纸了------------------");
        //小明又不想定了，取消报纸了
        peopleNewsPaper.removeSubcriber(_xiaoming);
        //又有报纸了，但小明取消了报纸订阅，所以他收不到报纸
        peopleNewsPaper.sendNewsPaper();
    }

//    private void initView() {
//        mTextView = findViewById(R.id.textView);
//    }
//
//    private void initEvent() {
//        mTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        });
//        //观察者加入列表
//        ObserverManager.getInstance().add(this);
//    }
//
//    @Override
//    public void updateData(String content) {
//        Log.d("vvvvvvvvvvvvvvv","11111111111");
//        mTextView.setText(content);
//    }
}
