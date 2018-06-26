package com.moible.observerdesignpatterndemo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements ObserverListener{
    private TextView mTextView;
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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
                Intent intent = new Intent(mContext,ThirdActivity.class);
                startActivity(intent);
            }
        });
        //观察者加入列表
        ObserverManager.getInstance();
    }

    @Override
    public void updateData(String content) {
        Log.d("vvvvvvvvvvvvvvv","2222222222");
        mTextView.setText(content);
    }
}
