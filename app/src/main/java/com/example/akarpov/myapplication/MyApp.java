package com.example.akarpov.myapplication;

import com.parse.Parse;
import com.parse.ParseInstallation;

import android.app.Application;

/**
 * Created by akarpov on 1/18/15.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "SzRF4OTakYGgJrm8iOEMb3f5diRpu6DqeZui3TQn",
                "jmstGxScVgEyw2cQWxF59Vdg2ru97b16itrh0Uvu");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
