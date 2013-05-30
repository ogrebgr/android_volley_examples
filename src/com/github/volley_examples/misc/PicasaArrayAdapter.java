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

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.volley_examples.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class PicasaArrayAdapter extends ArrayAdapter<PicasaEntry> {
    private ImageLoader mImageLoader;
    
    public PicasaArrayAdapter(Context context, 
                              int textViewResourceId, 
                              List<PicasaEntry> objects,
                              ImageLoader imageLoader
                              ) {
        super(context, textViewResourceId, objects);
        mImageLoader = imageLoader;
    }

    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.lv_picasa_row, null);
        }
        
        ViewHolder holder = (ViewHolder) v.getTag(R.id.id_holder);       
        
        if (holder == null) {
            holder = new ViewHolder(v);
            v.setTag(R.id.id_holder, holder);
        }        
        
        PicasaEntry entry = getItem(position);
        if (entry.getThumbnailUrl() != null) {
            holder.image.setImageUrl(entry.getThumbnailUrl(), mImageLoader);
        } else {
            holder.image.setImageResource(R.drawable.no_image);
        }
        
        holder.title.setText(entry.getTitle());
        
        return v;
    }
    
    
    private class ViewHolder {
        NetworkImageView image;
        TextView title; 
        
        public ViewHolder(View v) {
            image = (NetworkImageView) v.findViewById(R.id.iv_thumb);
            title = (TextView) v.findViewById(R.id.tv_title);
            
            v.setTag(this);
        }
    }
}
