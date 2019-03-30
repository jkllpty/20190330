package com.example.a20190330;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by lk
 * com.example.a20190330
 * 2019/3/30
 */
public class FourActivity extends AppCompatActivity {


    EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
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
            List<Long> list1 = new ArrayList<>();
            List<Integer> inputList = Arrays.asList(2, 5, 13, 19, 23);
            list1.add(Long.valueOf(1));
            for (Long N = Long.valueOf(1); N < 10000; N++) {
                List<Integer> integerList = check(N);
                for (int i = 0; i < integerList.size(); i++) {
                    int count = 0;
                    if (inputList.contains(integerList.get(i))) {
                        count++;
                    }
                    if (count == integerList.size()) {
                        list1.add(N);
                    }
                }
            }
            new AlertDialog.Builder(this)
                    .setTitle("计算结果")
                    .setMessage(list1.toString())
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

    public List<Integer> check(long aLong) {
        List<Integer> list = new ArrayList<>();
        int a = (int) Math.sqrt(aLong) + 1;
        int i = 2;
        while (aLong != 1 && i <= a) {
            if (aLong % i == 0) {
                aLong /= i;
                list.add(i);
                i = 2;
            } else {
                i++;
            }
        }
        if (i > a) {
            list.add(i);
        }
        return list;
    }
}
