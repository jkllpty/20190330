package com.example.a20190330;

import android.app.AppComponentFactory;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a20190330.solution.Test03;

import java.util.Arrays;

/**
 * create by lk
 * com.example.a20190330
 * 2019/3/30
 */
public class ThirdActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        et = findViewById(R.id.et_2);

    }

    public void submit(View view) {
        try {
            String input = et.getText().toString().trim();
            Integer n = Integer.valueOf(input);
            new AlertDialog.Builder(this)
                    .setTitle("计算结果")
                    .setMessage(String.valueOf(showJoseph(n, 3)))
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

    private static int showJoseph(int total, int cycle) {
        boolean[] arr = new boolean[total];
        Arrays.fill(arr, true);
        //true表示还活着的
        int kill = 0;
        int index = 0;
        int result = 0;
        while (kill < total) {
            for (int i = 0; i < cycle; i++) {
                while (!arr[index]) {
                    index = (index + 1) % total;
                }
                if (i == cycle - 1) {
                    arr[index] = false;
                    kill++;
                    index++;
                }
                if (kill == total - 1) {
                    result = (index + 1);
                }
                index = (index + 1) % total;
            }
        }
        return result;
    }
}
