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

import java.io.InputStream;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley_examples.R;
import com.github.volley_examples.toolbox.ExtHttpClientStack;
import com.github.volley_examples.toolbox.SslHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * Demonstrates how to execute HTTPS request against server with self-signed certificate.
 * @author Ognyan Bankov
 *
 */
public class Act_SsSslHttpClient extends Activity {
    private TextView mTvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act__ss_ssl_http_client);

        mTvResult = (TextView) findViewById(R.id.tv_result);

        Button btnSimpleRequest = (Button) findViewById(R.id.btn_simple_request);
        btnSimpleRequest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                
               //File bks for trust the server certificate in there import server certificate
               InputStream trustKeyStore = getResources().openRawResource(R.raw.clienttruststore);
               //File bks client certificate, only if you want mutual auth
               //Otherwise keyStore = null
               InputStream keyStore = getResources().openRawResource(R.raw.client);
                
                
                // Usually getting the request queue shall be in singleton like in {@see Act_SimpleRequest}
                // Current approach is used just for brevity
                RequestQueue queue = Volley
                        .newRequestQueue(Act_SsSslHttpClient.this,
                                         new ExtHttpClientStack(new SslHttpClient(trustKeyStore, "password", 443,keyStore)));

                StringRequest myReq = new StringRequest(Method.GET,
                                                        "https://ave.bolyartech.com:44401/https_test.html",
                                                        createMyReqSuccessListener(),
                                                        createMyReqErrorListener());

                queue.add(myReq);
            }
        });
    }


    private Response.Listener<String> createMyReqSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTvResult.setText(response);
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
