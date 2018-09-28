package io.forus.me.android.data.entity.applogin;

import com.google.gson.annotations.SerializedName;

public class AllowRequest {

    @SerializedName("key")
    private String key;

    @SerializedName("auth_token")
    private String authToken;

    @SerializedName("is_subscribe")
    private Boolean isSubscribe = false;

    public AllowRequest() { }

    public AllowRequest(String key, String authToken, Boolean isSubscribe) {
        this.key = key;
        this.authToken = authToken;
        this.isSubscribe = isSubscribe;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Boolean getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(Boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }
}
