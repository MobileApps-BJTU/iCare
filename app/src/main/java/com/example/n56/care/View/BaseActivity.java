package com.example.n56.care.View;

import android.app.ActivityGroup;
import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.n56.care.R;

import java.util.LinkedList;


public abstract class BaseActivity  extends Activity {
    //将生成的Activity都放到LinkList集合中
    protected static LinkedList<BaseActivity> queue = new LinkedList<BaseActivity>();
    //public static Conmmunication con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //判断该Activity是否在LinkedList中，没有在的话就添加上
        if (!queue.contains(this)) {
            queue.add(this);
            System.out.println("将" + queue.getLast() + "添加到list中去");
        }

        setContentView(R.layout.activity_base);
    }

    public abstract void processMessage(Message message);

    private static Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case 0:

                    break;

                default:

                    break;
            }


        }

        ;
    };

    //发送消息（、、、）
    public static void sendMessage(Message msg) {
        handler.sendMessage(msg);

    }
}


