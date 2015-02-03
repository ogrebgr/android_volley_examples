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

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import khandroid.ext.apache.http.conn.ssl.SSLSocketFactory;


class SslSocketFactory extends SSLSocketFactory {
    
    private static KeyManager [] mKeyManager;

   public SslSocketFactory(InputStream mTrustKeyStore, String keyStorePassword, InputStream keyStore) throws GeneralSecurityException {
        super(createSSLContext(mTrustKeyStore, keyStorePassword,keyStore), STRICT_HOSTNAME_VERIFIER);
    }


    private static SSLContext createSSLContext(InputStream mTrustkeyStore, String keyStorePassword,InputStream keyStore) throws GeneralSecurityException {
        SSLContext sslcontext = null;
        KeyStore key =null;
        try {

            if (keyStore!=null){
            //add keystore for mutual auth
            key = KeyStore.getInstance("BKS");
            key.load(keyStore, keyStorePassword.toCharArray());
            KeyManagerFactory kmf = KeyManagerFactory
                    .getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(key, keyStorePassword.toCharArray());
            mKeyManager = kmf.getKeyManagers();

            }
            else{
            //if mutual auth not need this parameter is null
            mKeyManager = null;

            }
            
            sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(mKeyManager, new TrustManager[] { new SsX509TrustManager(keyStore, keyStorePassword) }, null);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Failure initializing default SSL context", e);
        } catch (KeyManagementException e) {
            throw new IllegalStateException("Failure initializing default SSL context", e);
        }

        return sslcontext;
    }
}    
