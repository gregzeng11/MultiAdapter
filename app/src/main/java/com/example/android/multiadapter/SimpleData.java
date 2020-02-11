package com.example.android.multiadapter;

import androidx.annotation.NonNull;

/**
 * created by zyh
 * on 2019-10-11
 */
public class SimpleData {
    public @NonNull
    User user;
    public @NonNull SimpleContent content;
    public @NonNull String createTime;
   


    public SimpleData(@NonNull User user, @NonNull SimpleContent content) {
        this.user = user;
        this.content = content;
        this.createTime = "Just now";
    }


    @Override
    public String toString() {
        return "content: " + content.getClass().getSimpleName();
    }
}
