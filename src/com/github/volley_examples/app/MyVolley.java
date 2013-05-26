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
import com.github.volley_examples.toolbox.FakeImageCache;

/**
 * Helper class that is used to provide references to initialized RequestQueue(s) and ImageLoader(s)
 * 
 * @author Ognyan Bankov
 *
 */
public class MyVolley {
    private static RequestQueue mRequestQueue;
    private static ImageLoader mImageLoaderNoMemCache;


    private MyVolley() {
        // no instances
    }


    static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mImageLoaderNoMemCache = new ImageLoader(mRequestQueue, new FakeImageCache());
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
    public static ImageLoader getImageLoaderNoMemCache() {
        if (mImageLoaderNoMemCache != null) {
            return mImageLoaderNoMemCache;
        } else {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}
