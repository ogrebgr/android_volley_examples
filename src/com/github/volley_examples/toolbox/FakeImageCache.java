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

package com.github.volley_examples.toolbox;

import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader;


/**
 * Fake cache, i.e. no caching is done. 
 * This class exist just to implement ImageLoader.ImageCache and be used 
 * when no memory cache is needed
 * @author Ognyan Bankov
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
