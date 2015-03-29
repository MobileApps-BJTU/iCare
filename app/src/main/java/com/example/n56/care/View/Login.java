package com.example.n56.care.View;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.n56.care.R;


public class Login extends BaseActivity implements View.OnClickListener {


    private TextView registerTextView;
    private Button loginButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.ring_holder, new Ring())
                .commit();

        registerTextView = (TextView)findViewById(R.id.registerTextView);
        loginButton = (Button)findViewById(R.id.loginButton);
        registerTextView.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {

            case R.id.loginButton:
                Intent intent1 = new Intent();
                intent1.setClass(this, MainActivity.class); //
                startActivity(intent1);
                finish();
                break;
            case R.id.registerTextView:
                Intent intent2 = new Intent();
                intent2.setClass(this, Register.class); //
                startActivity(intent2);
                break;


        }
    }

    @Override
    public void processMessage(Message message) {

    }
}
