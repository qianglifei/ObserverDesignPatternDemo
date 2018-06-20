package com.moible.observerdesignpatterndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ObserverListener {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        //观察者加入列表
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void updateData(String content) {
        Log.d("vvvvvvvvvvvvvvv","11111111111");
        mTextView.setText(content);
    }
}
