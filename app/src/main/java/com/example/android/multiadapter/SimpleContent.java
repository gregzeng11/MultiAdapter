package com.example.android.multiadapter;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

/**
 * created by zyh
 * on 2019-10-11
 */
public abstract  class SimpleContent {
    @SerializedName("content_type")
    public final @NonNull
    String contentType;


    protected SimpleContent(@NonNull String contentType) {
        this.contentType = contentType;
    }
}
