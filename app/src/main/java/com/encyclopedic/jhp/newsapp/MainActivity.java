package com.encyclopedic.jhp.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.encyclopedic.jhp.newsapp.NewsApp.NewsAppActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.tonewsapp);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tonewsapp:
                Intent intent=new Intent(MainActivity.this,NewsAppActivity.class);
                startActivityForResult(intent,1);
        }
    }
}
