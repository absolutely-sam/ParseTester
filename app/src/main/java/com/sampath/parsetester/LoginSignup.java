package com.sampath.parsetester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginSignup extends AppCompatActivity
{

    EditText username,password;
    Button login, signup;

    String userNameTxt, passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameTxt = username.getText().toString();
                passwordTxt = password.getText().toString();
                ParseUser.logInInBackground(userNameTxt, passwordTxt, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null)
                        {
                            startActivity(new Intent(LoginSignup.this,WelcomeActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"User Does not exist please signup",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameTxt = username.getText().toString();
                passwordTxt = password.getText().toString();

                if(userNameTxt.equals("") && passwordTxt.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"You ****** fill up the details",Toast.LENGTH_LONG).show();
                }
                else
                {
                    ParseUser user = new ParseUser();
                    user.setUsername(userNameTxt);
                    user.setPassword(passwordTxt);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e == null)
                            {
                                Toast.makeText(getApplicationContext(),"Successfully signed up",Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Error in Signing up",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }


            }
        });

    }
}
