package com.example.a20190330;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a20190330.solution.Answer8;

public class EightActivity extends AppCompatActivity {

    private TextView tvResult;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        tvResult = findViewById(R.id.tv_8);
        et = findViewById(R.id.et_8);
    }

    public void submit(View view) {
        final String url = et.getText().toString().trim();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = Answer8.getCertExpired(url);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvResult.setText(result);
                    }
                });
            }
        }).start();
    }
}
