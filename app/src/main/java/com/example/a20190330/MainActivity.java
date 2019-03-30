package com.example.a20190330;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

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
        startActivity(new Intent(this, ThirdActivity.class));

    }

    public void fourth(View view) {
        startActivity(new Intent(this, FourActivity.class));

    }

    public void fifth(View view) {

        startActivity(new Intent(this, FiveActivity.class));

    }

    public void six(View view) {
        startActivity(new Intent(this, SixActivity.class));

    }

    public void seven(View view) {
    }

    public void eight(View view) {
        startActivity(new Intent(this, EightActivity.class));
    }

    public void nine(View view) {
        startActivity(new Intent(this, NineActivity.class));

    }

    public void ten(View view) {
//        startActivity(new Intent(this, TenActivity.class));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");

        //获取html文件复制到sdcard后的路径,test.html是我放到项目中assets目录下的网页文件
        String path = new AssertToSdcard().transFilePath(
                MainActivity.this, "picture.html");
        new AssertToSdcard().transFilePath(MainActivity.this, "image.png");
        if (null != path) {
//             Uri content_url = Uri.parse("file:///sdcard/picture.html");
            //使用此种方法获取uri或者使用上面注释的方法获取uri
//            Uri content_url = Uri.fromFile(new File(path));
            Uri content_url = getUriForFile(this, new File(path));
            intent.setData(content_url);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");
//            intent.setComponent(new ComponentName("com.android.browser", "com.android.browser.BrowserActivity"));
            startActivity(intent);
        } else {
        }

    }

    public static Uri getUriForFile(Context context, File file) {
        Uri fileUri = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//24 android7
            fileUri = FileProvider.getUriForFile(context, "com.example.a20190330.fileProvider", file);
        } else {
//            if(!ApplicationHelper.hasExternalStorage())
//                ApplicationHelper.chmodFile(file);//没有SD卡，需要更改文件权限
//            //file.setReadable(true,false);
            fileUri = Uri.fromFile(file);
        }
        return fileUri;
    }
}
