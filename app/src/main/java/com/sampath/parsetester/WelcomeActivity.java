package com.sampath.parsetester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.*;

import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity
{

    Button logout;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        logout = (Button) findViewById(R.id.logout);
        username = (TextView) findViewById(R.id.usernametext);

        ParseUser currentUser = ParseUser.getCurrentUser();
        String strUser = currentUser.getUsername().toString();

        username.setText("You are logged in as "+strUser);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                finish();
            }
        });

    }
}
