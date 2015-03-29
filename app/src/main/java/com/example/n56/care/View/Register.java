package com.example.n56.care.View;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.n56.care.R;

public class Register extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.ring_holder, new Ring())
                .commit();
    }

    @Override
    public void processMessage(Message message) {

    }
}
