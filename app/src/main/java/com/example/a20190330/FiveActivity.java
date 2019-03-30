package com.example.a20190330;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.a20190330.solution.Test05;

import java.util.List;

public class FiveActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        tvResult = findViewById(R.id.tv_5);
    }

    public void submit(View view) {
        String input = "123456789";
        int target = 140;
        List<String> result = Test05.addOperators(input, target);
        StringBuilder builder = new StringBuilder();
        builder.append("满足条件的情况如下").append("(").append("共").append(result.size()).append("条)\n\n");
        for (int i = 0; i < result.size(); i++) {
            builder.append(result.get(i)).append("\n");
        }
        tvResult.setText(builder.toString());
    }
}
