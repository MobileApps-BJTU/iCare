package com.example.n56.care.View;

import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.n56.care.R;

public class Me extends BaseActivity {

    private TextView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        profile= (TextView)findViewById(R.id.textView);

        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.me,new Profile()).addToBackStack(null).commit();
            }

        });


    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void processMessage(Message message) {

    }
}
