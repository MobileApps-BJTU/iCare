package com.example.n56.care.View;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n56.care.R;

public class Contacts extends BaseActivity {
    private ListView contacts;
    ArrayList<HashMap<String, Object>> mList;
    LayoutInflater inflater;
    Myadapter adapter;
    private Handler mHandler;

    private int[] headArray = {
            R.drawable.mom,
            R.drawable.dad,
            R.drawable.honey,
            R.drawable.baby
    };

    private String[] numberArray = {
            "5556",
            "18811442222",
            "13922520154",
            "15268545859",
    };

    private String[] nameArray = {
            "Mom",
            "Dad",
            "Honey",
            "Baby"
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        contacts = (ListView) findViewById(R.id.ListViewContacts);

        init();
    }

    //初始化界面
    private void init() {

        adapter = new Myadapter(Contacts.this);

        // 生成动态数组，加入数据
        mList = new ArrayList<HashMap<String, Object>>();

        for(int i = 0; i < headArray.length; i++) {
            // HashMap为键值对类型。第一个参数为键，第二个参数为值
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemHead", headArray[i]);
            map.put("ItemName", nameArray[i]);
            map.put("ItemNumber", numberArray[i]);
            mList.add(map);// 添加到listItem中
        }

        adapter = new Myadapter(Contacts.this);
        contacts.setAdapter(adapter);

        System.out.println("list   +++++++" + mList.size());

        //adapter.notifyDataSetChanged();

    }



    public class Myadapter extends BaseAdapter {

        private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

        /*构造函数*/
        public Myadapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO 自动生成的方法存根
            return mList.size();//返回数组的长度
        }

        @Override
        public Object getItem(int position) {
            // TODO 自动生成的方法存根
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO 自动生成的方法存根
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO 自动生成的方法存根
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.listview_contacts_item,null);
                holder = new ViewHolder();
	            /*得到各个控件的对象*/
                holder.ItemHead = (ImageView) convertView.findViewById(R.id.ItemHead);
                holder.ItemName = (TextView) convertView.findViewById(R.id.ItemName);
                holder.ItemDetail = (LinearLayout) convertView.findViewById(R.id.ItemDetail);
                holder.ItemLocate = (Button) convertView.findViewById(R.id.ItemLocate);
                holder.ItemChat = (Button) convertView.findViewById(R.id.ItemChat);
                convertView.setTag(holder);//绑定ViewHolder对象
            }else{
                holder = (ViewHolder)convertView.getTag();//取出ViewHolder对象
            }

            holder.ItemDetail.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            Contacts.this,
                            "Details of " + mList.get(position).get("ItemName").toString(),
                            Toast.LENGTH_SHORT).show();
                }
            });


            holder.ItemLocate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            Contacts.this,
                            "Location of " + mList.get(position).get("ItemName").toString() + mList.get(position).get("ItemNumber").toString(),
                            Toast.LENGTH_SHORT).show();

                    Intent in = new Intent(Contacts.this, Locate.class);
                    in.putExtra("number", mList.get(position).get("ItemNumber").toString());
                    startActivity(in);


                }
            });

            holder.ItemChat.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String[] items = {getString(R.string.chat_way_1),
                            getString(R.string.chat_way_2),
                            getString(R.string.chat_way_3)
                    };

                    new AlertDialog.Builder(Contacts.this)
                            .setTitle("Please choose:")
                            .setItems(items, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int item) {
                                    switch (item) {
                                        case 0:

                                            Intent intentText = new Intent(Contacts.this,Text.class);
                                            intentText.putExtra("head",headArray[position]);
                                            intentText.putExtra("name",mList.get(position).get("ItemName").toString());
                                            intentText.putExtra("number", mList.get(position).get("ItemNumber").toString());
                                            startActivity(intentText);
                                            break;
                                        case 1:
                                            Intent intentTalk = new Intent(Contacts.this,Talk.class);
                                            intentTalk.putExtra("head",headArray[position]);
                                            intentTalk.putExtra("name",mList.get(position).get("ItemName").toString());
                                            intentTalk.putExtra("number", mList.get(position).get("ItemNumber").toString());
                                            startActivity(intentTalk);

                                            // android call
                                            /*
                                            String number = mList.get(position).get("ItemNumber").toString();
                                            if (number.trim().length() != 0) {

                                                Intent phoneIntent = new Intent(
                                                        "android.intent.action.CALL", Uri.parse("tel:"
                                                        + number));
                                                startActivity(phoneIntent);
                                            }*/

                                                break;
                                        case 2:
                                            Intent intentVideoTalk = new Intent(Contacts.this,VideoTalk.class);
                                            intentVideoTalk.putExtra("head",headArray[position]);
                                            intentVideoTalk.putExtra("name",mList.get(position).get("ItemName").toString());
                                            intentVideoTalk.putExtra("number", mList.get(position).get("ItemNumber").toString());
                                            startActivity(intentVideoTalk);
                                            break;
                                    }
                                }
                            }).show();//显示对话框

                }
            });

	        /*设置TextView显示的内容，即我们存放在动态数组中的数据*/
            String name = mList.get(position).get("ItemName").toString();
            int head = (int)mList.get(position).get("ItemHead");

            holder.ItemName.setText(name);
            holder.ItemHead.setImageResource(head);
            return convertView;
        }

        /*存放控件*/
        public final class ViewHolder{
            public ImageView ItemHead;
            public TextView ItemName;
            public LinearLayout ItemDetail;
            public Button ItemLocate;
            public Button ItemChat;
        }

    }

    @Override
    public void processMessage(Message message) {

    }


}