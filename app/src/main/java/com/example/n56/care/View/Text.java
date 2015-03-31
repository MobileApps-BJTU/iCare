package com.example.n56.care.View;

import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.n56.care.R;
import com.example.n56.care.Util.TextMsgEntity;
import com.example.n56.care.Util.TextMsgViewAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Text extends BaseActivity implements View.OnClickListener{

    private TextView textTitle;
    private Button mBtnSend;
    private Button mBtnBack;
    private EditText mEditTextContent;
    private ListView mListView;
    private TextMsgViewAdapter mAdapter;
    private List<TextMsgEntity> mDataArrays = new ArrayList<TextMsgEntity>();
    private String name;
    private int head;
    private String[]msgArray = new String[]{"Hello.", "I've bought a phone 4 u", "Oh really?",
            "yeah", "that's great!", "Try that when I come home", "ok, u have dinner?", "not yet."};

    private String[]dataArray = new String[]{"2014-03-28 18:00", "2014-03-28 18:10",
            "2014-03-28 18:11", "2014-03-28 18:20",
            "2014-03-28 18:30", "2014-03-28 18:35",
            "2014-03-28 18:40", "2014-03-28 18:42"};
    private final static int COUNT = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        //启动activity时不自动弹出软键盘
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initView();

        Bundle bundle = getIntent().getExtras();
        name = (String)bundle.get("name");
        head = (int)bundle.get("head");
        if(name!=null) {
            textTitle.setText(name);
        }
        initData();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.ring_holder, new Ring())
                .commit();
    }

    public void initView()
    {
        textTitle = (TextView)findViewById(R.id.TextTitle);
        mListView = (ListView) findViewById(R.id.listview);
        mBtnSend = (Button) findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
        mEditTextContent = (EditText) findViewById(R.id.et_message);
    }

    public void initData()
    {
        for(int i = 0; i < COUNT; i++)
        {
            TextMsgEntity entity = new TextMsgEntity();
            entity.setDate(dataArray[i]);
            if (i % 2 == 0)
            {
                entity.setHead(head);
                entity.setName(name);
                entity.setMsgType(true);
            }else{
                entity.setHead(R.drawable.me);
                entity.setName(getString(R.string.me));
                entity.setMsgType(false);
            }

            entity.setText(msgArray[i]);
            mDataArrays.add(entity);
        }

        mAdapter = new TextMsgViewAdapter(this, mDataArrays);
        mListView.setAdapter(mAdapter);

    }



    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.btn_send:
                send();
                break;
        }
    }

    private void send()
    {
        String contString = mEditTextContent.getText().toString();
        if (contString.length() > 0)
        {
            TextMsgEntity entity = new TextMsgEntity();
            entity.setDate(getDate());
            entity.setName(getString(R.string.me));
            entity.setMsgType(false);
            entity.setText(contString);

            mDataArrays.add(entity);
            mAdapter.notifyDataSetChanged();

            mEditTextContent.setText("");

            mListView.setSelection(mListView.getCount() - 1);
        }
    }

    private String getDate() {
        Calendar c = Calendar.getInstance();

        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH));
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
        String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mins = String.valueOf(c.get(Calendar.MINUTE));


        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":" + mins);

        return sbBuffer.toString();
    }

    @Override
    public void processMessage(Message message) {

    }

}