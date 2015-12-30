package com.sampath.parsetester;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Sampath Kumar on 12/30/2015.
 */
public class ParseApp extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "nsIPZ4zdySKxyRggnDX29heJf3y0YiynUoyeOUah", "lvJfikv23lDWqucmXCxAn800EMUdExY6fopBPsvl");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL,true);
    }
}
