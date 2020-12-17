package com.example.wepapi;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Comment {

    @SerializedName("body")
    private String mBody;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("postId")
    private Long mPostId;

    public String getBody() {
        return mBody;
    }

    public String getEmail() {
        return mEmail;
    }

    public Long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public Long getPostId() {
        return mPostId;
    }

}
