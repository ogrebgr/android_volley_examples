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

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.volley_examples.R;
import com.github.volley_examples.app.MyVolley;
import com.github.volley_examples.misc.Requests;


public class Act_MultipleRequests extends Activity {
    private TextView mTvResult;
    private RequestQueue mRequestQueue;
    private Response.ErrorListener mErrorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act__multiple_requests);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        // 1. Initialize the queue.
        mRequestQueue = MyVolley.getRequestQueue();
        
        // 2. Initialize the error listener instance variable. It will be used for all requests.
        mErrorListener = createErrorListener();

        
        Button btnSimpleRequest = (Button) findViewById(R.id.btn_request);
        btnSimpleRequest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Execute request 1 (to www.google.com) with its success listener and the common error listener
                Requests.request1(mRequestQueue, createMyReq1SuccessListener(), mErrorListener);
            }
        });
        
    }
   
    
    private Response.Listener<String> createMyReq1SuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTvResult.setText(response);
                // Here you can process the result from the request1 and decide for example to execute request 2:
                // 4. Execute request 2 (to www.slashdot.org) with its success listener and the common error listener
                Requests.request2(mRequestQueue, createMyReq2SuccessListener(), mErrorListener);
            }
        };
    }

    
    private Response.Listener<String> createMyReq2SuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                AlertDialog.Builder b = new AlertDialog.Builder(Act_MultipleRequests.this);
                
                //5. Process the result from request 2 or/and for example show some dialog
                // The 3 lines bellow have to use string.xml for their strings, not as now with hardcoded string literals
                b.setMessage("Communication ended successfully");
                b.setTitle("Success");
                b.setNeutralButton("OK", null);
                b.show();
            }
        };
    }


    private Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog.Builder b = new AlertDialog.Builder(Act_MultipleRequests.this);
                
                // The 3 lines bellow have to use string.xml for their strings, not as now with hardcoded string literals
                b.setMessage("Some error occured during the communication with the server.");
                b.setTitle("Error");
                b.setNeutralButton("Close", null);
                b.show();
            }
        };
    }
}
