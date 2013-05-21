package com.example.volley_examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Act_ImageLoading extends Activity {
   private ImageView mImageView;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act__image_loading);
      
      mImageView = (ImageView) findViewById(R.id.iv_image);
      
   }
}
