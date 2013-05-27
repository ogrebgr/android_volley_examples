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

package com.github.volley_examples.misc;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;


/**
 * This class is ment to serve as container for requests. That way you don't "polute" your activities/fragments with
 * the creation of the request which just adds code lines and thus lowering the readability and comprehensibility. For
 * this method to work properly you need to choose meaningful and descriptive create* methods. Examples for good names:
 * <ul>
 * <li><code>executeLogin</code></li>
 * <li><code>executeRegisterUser</code></li>
 * <li><code>executeSearchInProducts</code></li>
 * </ul>
 * <p>
 * Example for bad names: all the names in the class bellow. Sorry. For meaningful names we need full system with not
 * just android code but also server backend.
 * </p>
 * <p>
 * In real apps is quite normal to have 40+ different requests so you may want to additionally arrange and group them in
 * static inner classes. For example all request about user like login, register, user details may reside in inner class
 * <code>User</code>; all request about products like product list, search in products, view product may reside in class
 * <code>Product</code>. You will use them like: Requests.User.executeLogin(..), Requests.Product.executeSearchInProducts().
 * </p>
 * It will be better if you don't use string literals as in the code bellow. It is much better to move the URLs to string constacts
 * @author Ognyan Bankov
 * 
 */
public class Requests {
    public static void request1(RequestQueue queue,
                                       Response.Listener<String> successListener,
                                       Response.ErrorListener errorListener) {

        StringRequest req = new StringRequest(Method.GET,
                                              NetworkConstants.URL_REQUEST1,
                                              successListener,
                                              errorListener);

        queue.add(req);
    }


    public static void request2(RequestQueue queue,
                                       Response.Listener<String> successListener,
                                       Response.ErrorListener errorListener) {

        StringRequest req = new StringRequest(Method.GET,
                                              NetworkConstants.URL_REQUEST2,
                                              successListener,
                                              errorListener);

        queue.add(req);
    }
}
