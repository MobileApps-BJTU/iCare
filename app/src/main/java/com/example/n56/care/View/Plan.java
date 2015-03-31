package com.example.n56.care.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.example.n56.care.R;

public class Plan extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

    }


    @Override
    public void processMessage(Message message) {

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                // 创建退出对话框
                AlertDialog isExit = new AlertDialog.Builder(this).create();
                // 设置对话框标题
                isExit.setTitle(getString(R.string.systemInfo));
                // 设置对话框消息
                isExit.setMessage(getString(R.string.verification));
                // 添加选择按钮并注册监听
                isExit.setButton(getString(R.string.yes), listener);
                isExit.setButton2(getString(R.string.no), listener);
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
}
