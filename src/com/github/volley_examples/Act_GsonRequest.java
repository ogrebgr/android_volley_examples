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

package com.github.volley_examples;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.example.volley_examples.R;
import com.github.volley_examples.app.MyVolley;
import com.github.volley_examples.misc.MyClass;
import com.github.volley_examples.toolbox.GsonRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Demonstrates how to use Volley along with Gson
 * @author Ognyan Bankov
 *
 */
public class Act_GsonRequest extends Activity {
    private TextView mTvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.act__gson_request);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        Button btnSimpleRequest = (Button) findViewById(R.id.btn_gson_request);
        btnSimpleRequest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = MyVolley.getRequestQueue();
                GsonRequest<MyClass> myReq = new GsonRequest<MyClass>(Method.GET,
                                                        "http://validate.jsontest.com/?json={'key':'value'}",
                                                        MyClass.class,
                                                        createMyReqSuccessListener(),
                                                        createMyReqErrorListener());

                queue.add(myReq);
            }
        });
    }
    
    
    private Response.Listener<MyClass> createMyReqSuccessListener() {
        return new Response.Listener<MyClass>() {
            @Override
            public void onResponse(MyClass response) {
                mTvResult.setText(Long.toString(response.getNanoseconds()));
            }
        };
    }
    
    
    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTvResult.setText(error.getMessage());
            }
        };
    }
}
