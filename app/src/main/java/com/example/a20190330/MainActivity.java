package com.example.a20190330;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void first(View view) {
        startActivity(new Intent(this, FirstActivity.class));
    }

    public void second(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void third(View view) {
    }

    public void fourth(View view) {
    }

    public void fifth(View view) {
    }

    public void six(View view) {
    }

    public void seven(View view) {
    }

    public void eight(View view) {
    }

    public void nine(View view) {
    }

    public void ten(View view) {
    }
}
