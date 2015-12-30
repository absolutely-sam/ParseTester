package com.sampath.parsetester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser()))
        {
            startActivity(new Intent(MainActivity.this,LoginSignup.class));
            finish();
        }
        else
        {
            ParseUser currentUser = ParseUser.getCurrentUser();
            if(currentUser != null)
            {
                startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
                finish();
            }
            else
            {
                startActivity(new Intent(MainActivity.this,LoginSignup.class));
                finish();
            }
        }

    }
}
