package com.example.wepapi;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Post {

    @SerializedName("body")
    private String mBody;
    @SerializedName("id")
    private Long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("userId")
    private Long mUserId;

    public String getBody() {
        return mBody;
    }

    public Long getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Long getUserId() {
        return mUserId;
    }

}
