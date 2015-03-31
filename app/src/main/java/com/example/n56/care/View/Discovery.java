package com.example.n56.care.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.n56.care.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Discovery extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discovery);

        init();
    }

    private void init(){
        // 绑定Layout里的ListView
        ListView list = (ListView) findViewById(R.id.ListViewDiscovery);
        int[] imageArray = {
                R.drawable.moments,
                R.drawable.scan,
                R.drawable.neighbors,
                R.drawable.entertainment
        };

        String[] titleArray = {
                getString(R.string.discovery_moments),
                getString(R.string.discovery_scan),
                getString(R.string.discovery_neighbors),
                getString(R.string.discovery_entertainment)
        };

        // 生成动态数组，加入数据
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

        for(int i = 0; i < titleArray.length; i++) {
            // HashMap为键值对类型。第一个参数为键，第二个参数为值
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", imageArray[i]);// 图像资源图片，显示在小项右端
            map.put("ItemTitle", titleArray[i]);
            listItem.add(map);// 添加到listItem中
        }

        // 生成适配器的Item和动态数组对应的元素，这里用SimpleAdapter作为ListView的数据源
        // 如果条目布局比较复杂，可以继承BaseAdapter来定义自己的数据源。
        // 生成一个SimpleAdapter类型的变量来填充数据
        SimpleAdapter listItemAdapter = new SimpleAdapter(
                this,// this是当前Activity的对象
                listItem,// 数据源 为填充数据后的ArrayList类型的对象
                R.layout.listview_discovery_item,// 子项的布局.xml文件名
                new String[] { "ItemImage", "ItemTitle" },
                // 这个String数组中的元素就是list对象中的列，list中有几这个数组中就要写几列。
                new int[] { R.id.ItemImage, R.id.ItemTitle });// 值是对应XML布局文件中的一个ImageView,三个TextView的id
        // 添加并显示
        list.setAdapter(listItemAdapter);

        // 添加点击
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // 重写单击响应
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //setTitle("点击第" + arg2 + "个项目");// 直接在标题显示
                switch (arg2){
                    case 0:
                        Intent intent = new Intent();
                        intent.setClass(Discovery.this, Moments.class);
                        startActivity(intent);
                        break;
                }

            }
        });
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
