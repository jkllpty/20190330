package com.example.a20190330;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * create by lk
 * com.example.a20190330
 * 2019/3/30
 */
public class SixActivity extends AppCompatActivity {

    EditText et;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        et = findViewById(R.id.et_2);

    }

    public void submit(View view) {
        try {
            String input = et.getText().toString().trim();
            String[] s = input.split(",");
            for (int i = 0; i < s.length; i++) {
                if (Integer.parseInt(s[i]) <= 10) {
                    Toast.makeText(this, String.valueOf(-1), Toast.LENGTH_LONG);
                }
            }
            final List<Call> list = new ArrayList<>();
            List<Request> list1 = new ArrayList<>();

            for (int i = 0; i < s.length; i++) {
                String url = "https://exam.cmbccdn.cn/" + s[i] + ".xml";
                OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                list1.add(request);
                final Call call = okHttpClient.newCall(request);
                list.add(call);
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        final List<String> re = new ArrayList<>();
                        for (int i = 0; i < list.size(); i++) {
                            Response response = list.get(i).execute();
                            try {
                                re.add(parseXMLWithPull(response.body().string()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        final StringBuffer stringBuffer = new StringBuffer();
                        for (int j = 0; j < re.size(); j++) {
                            stringBuffer.append(re.get(j)+" ");
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                new AlertDialog.Builder(SixActivity.this)
                                        .setTitle("计算结果")
                                        .setMessage(stringBuffer.toString())
                                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.dismiss();
                                                    }
                                                }).create().show();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            Toast.makeText(this, "参数输入有误...", Toast.LENGTH_SHORT).show();
        }

    }

    private String parseXMLWithPull(String result) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(result));
            String nWidth = "";
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = parser.getName();
                Log.d("tag", "nodeName: " + nodeName);
                switch (eventType) {
                    case XmlPullParser.START_TAG://开始解析
                        if ("PerspectiveTransform".equals(nodeName)) {
                            nWidth = parser.getAttributeValue(null, "nWidth");
                        }
                        break;

                    case XmlPullParser.END_TAG://完成解析
                        if ("PerspectiveTransform".equals(nodeName)) {
                            Log.i("nWidth", "nWidth : " + nWidth);
                            return nWidth;
                        }
                        break;
                    default:

                        break;
                }
                eventType = parser.next();
            }
            return nWidth;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return String.valueOf(-1);
        } catch (IOException e) {
            e.printStackTrace();
            return String.valueOf(-1);
        }
    }
}
