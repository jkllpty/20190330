package com.example.a20190330;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * create by lk
 * com.example.a20190330
 * 2019/3/30
 */
public class NineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        String[] pyStrs = PinyinHelper.toHanyuPinyinStringArray('重');
        for (String s : pyStrs) {
            Log.e("pyStrs", s);
        }
    }
}
