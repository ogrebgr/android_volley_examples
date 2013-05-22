package com.example.volley_examples.toolbox;

import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader;


/**
 * Fake cache, i.e. no caching is done. 
 * This class exist just to implement ImageLoader.ImageCache and be used 
 * when no memory cache is needed
 * @author ogre
 *
 */
public class FakeImageCache implements ImageLoader.ImageCache {

    @Override
    public Bitmap getBitmap(String url) {
        return null;
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
    }

}
