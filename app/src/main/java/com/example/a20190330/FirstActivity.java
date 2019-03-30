package com.example.a20190330;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20190330.solution.Test01;

import java.text.MessageFormat;

public class FirstActivity extends AppCompatActivity {

    private EditText et_1, et_2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        et_1 = findViewById(R.id.et_1_1);
        et_2 = findViewById(R.id.et_2_2);
        tvResult = findViewById(R.id.tv_result);



    }

    public void submit(View view) {
        try {
            String input1 = et_1.getText().toString().trim();
            String input2 = et_2.getText().toString().trim();
            String[] nums1 = input1.split("，");
            String[] nums2 = input2.split("，");
            int[] intList1 = new int[nums1.length];
            int[] intList2 = new int[nums2.length];
            for (int i = 0; i < intList1.length; i++) {
                intList1[i] = Integer.valueOf(nums1[i]);
            }
            for (int i = 0; i < intList2.length; i++) {
                intList2[i] = Integer.valueOf(nums2[i]);
            }
            ListNode node1 = ListNode.creatList(intList1);
            ListNode node2 = ListNode.creatList(intList2);
            ListNode result = Test01.addTwoNumbers(node1, node2);
            tvResult.setText(MessageFormat.format("计算结果为：\n{0}", ListNode.printList(result)));
            tvResult.setVisibility(View.GONE);
            new AlertDialog.Builder(this)
                    .setTitle("计算结果")
                    .setMessage(ListNode.printList(result))
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        } catch (Exception e) {
            Toast.makeText(this, "参数输入不合法...", Toast.LENGTH_SHORT).show();
        }

    }


}
