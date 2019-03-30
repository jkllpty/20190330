package com.example.a20190330;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a20190330.solution.Test02;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et = findViewById(R.id.et_2);
    }

    public void submit(View view) {
        try {
            String input = et.getText().toString().trim();
            String[] inputArray = input.split("，");
            int[] inputNums = new int[inputArray.length];
            for (int i = 0; i < inputNums.length; i++) {
                inputNums[i] = Integer.valueOf(inputArray[i]);
            }
            List<List<Integer>> result = Test02.threeSum(inputNums);
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i = 0; i < result.size(); i++) {
                builder.append("\n").append("[");
                builder.append(result.get(i).get(0));
                for (int j = 1; j < result.get(i).size(); j++) {
                    builder.append(",").append(result.get(i).get(j));
                }
                builder.append("]").append("\n");
            }
            builder.append("\n").append("]");
            new AlertDialog.Builder(this)
                    .setTitle("计算结果")
                    .setMessage(builder.toString())
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        } catch (Exception e) {
            Toast.makeText(this, "参数输入有误...", Toast.LENGTH_SHORT).show();
        }
    }
}
