package com.example.n56.care.View;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.example.n56.care.R;

public class MainActivity extends ActivityGroup {

    private TabHost tabHost;		//声明TabHost组件的对象
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost=(TabHost)findViewById(android.R.id.tabhost);	//获取TabHost对象
        tabHost.setup();	//初始化TabHost组件
        tabHost.setup(this.getLocalActivityManager());

        tabHost.addTab(tabHost.newTabSpec("tab01")
                .setIndicator("Contacts")
                .setContent(new Intent(MainActivity.this,Contacts.class)));   //添加第一个标签页
        tabHost.addTab(tabHost.newTabSpec("tab02")
                .setIndicator("Discovery")
                .setContent(new Intent(MainActivity.this, Discovery.class)));  	//添加第二个标签页
        tabHost.addTab(tabHost.newTabSpec("tab03")
                .setIndicator("Plan")
                .setContent(new Intent(MainActivity.this,Plan.class)));  	//添加第三个标签页
        tabHost.addTab(tabHost.newTabSpec("tab04")
                .setIndicator("Me")
                .setContent(new Intent(MainActivity.this,Me.class)));  	//添加第四个标签页
    }

/*
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                // 创建退出对话框
                AlertDialog isExit = new AlertDialog.Builder(this).create();
                // 设置对话框标题
                isExit.setTitle("系统提示");
                // 设置对话框消息
                isExit.setMessage("确定要退出吗");
                // 添加选择按钮并注册监听
                isExit.setButton("确定", listener);
                isExit.setButton2("取消", listener);
                // 显示对话框
                isExit.show();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    System.exit(0);
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };
    */
}
