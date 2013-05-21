package com.example.volley_examples;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class Act_Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act__main);

        Button btnSimpleRequest = (Button) findViewById(R.id.btn_simple_request);
        btnSimpleRequest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act_Main.this, Act_SimpleRequest.class);
                startActivity(intent);
            }
        });

        Button btnJsonRequest = (Button) findViewById(R.id.btn_json_request);
        btnJsonRequest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act_Main.this, Act_JsonRequest.class);
                startActivity(intent);
            }
        });
        
        Button btnGsonRequest = (Button) findViewById(R.id.btn_gson_request);
        btnGsonRequest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act_Main.this, Act_GsonRequest.class);
                startActivity(intent);
            }
        });        
        Button btnImageLoading = (Button) findViewById(R.id.btn_image_loading);
        btnImageLoading.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
              Intent intent = new Intent(Act_Main.this, Act_ImageLoading.class);
              startActivity(intent);
           }
        });        
        
    }
}
