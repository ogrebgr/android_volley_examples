package com.example.volley_examples.misc;

import com.google.gson.annotations.SerializedName;

public class MyClass {
    @SerializedName("object_or_array")
    private String mType;
    
    @SerializedName("empty")
    private boolean mIsEmpty;
    
    @SerializedName("parse_time_nanoseconds")
    private long mNanoseconds;
    
    @SerializedName("validate")
    private boolean mIsValid;


    public String getType() {
        return mType;
    }


    public boolean isIsEmpty() {
        return mIsEmpty;
    }


    public long getNanoseconds() {
        return mNanoseconds;
    }


    public boolean isIsValid() {
        return mIsValid;
    }
}
