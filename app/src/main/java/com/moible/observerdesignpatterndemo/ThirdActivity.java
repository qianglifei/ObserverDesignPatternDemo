package com.moible.observerdesignpatterndemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements ObserverListener{
    private TextView mTextView;
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //初始化View
        initView();
        //初始化事件
        initEvent();
    }

    private void initView() {
        mTextView = findViewById(R.id.textView);
    }

    private void initEvent() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObserverManager.getInstance().notifyObserver("观察者请刷新信息");
            }
        });
        //观察者加入列表
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void updateData(String content) {
        Log.d("vvvvvvvvvvvvvvv","333333333333");
        mTextView.setText(content);
    }
}
