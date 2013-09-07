/**
 * Copyright 2013 Ognyan Bankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.volley_examples.app;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.github.volley_examples.toolbox.BitmapLruCache;


/**
 * Helper class that is used to provide references to initialized RequestQueue(s) and ImageLoader(s)
 * 
 * @author Ognyan Bankov
 * 
 */
public class MyVolley {
    private static final int MAX_IMAGE_CACHE_ENTIRES  = 100;
    
    private static RequestQueue mRequestQueue;
    private static ImageLoader mImageLoader;


    private MyVolley() {
        // no instances
    }


    static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        /* 
         * Thanks to your sample codes. but.
         * please check MAX_IMAGE_CACHE_ENTRIES .. (I'm not meaning it's spelled)
         * you overrided sizeOf method in BitmapLruCache class that returns size of entry(bitmap).
         * but here you define maxSize to 100, that means set cache size to 100 byte.
         * So, no image can cache to LruCache.
         * Remove sizeOf method in BitmaplruCache class, 
         * or change max_image_cache_entries to some memory size like this.
         * int memClass = ((ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
		 *	// Use 1/8th of the available memory for this memory cache.
		 *	int cacheSize = 1024 * 1024 * memClass / 8;
		 * mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(MAX_IMAGE_CACHE_ENTIRES));
		 * 
		 */
		 //TODO please check MAX_IMAGE_CACHE_ENTIRES
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(MAX_IMAGE_CACHE_ENTIRES));
    }


    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }


    /**
     * Returns instance of ImageLoader initialized with {@see FakeImageCache} which effectively means
     * that no memory caching is used. This is useful for images that you know that will be show
     * only once.
     * 
     * @return
     */
    public static ImageLoader getImageLoader() {
        if (mImageLoader != null) {
            return mImageLoader;
        } else {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}
