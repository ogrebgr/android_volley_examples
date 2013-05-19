package com.example.volley_examples.app;

import android.app.Application;


public class App_VolleyExamples extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        
        init();
    }


    private void init() {
        MyVolley.init(this);
    }
}
