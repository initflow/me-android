package io.forus.me.android.data.entity.applogin;

import com.google.gson.annotations.SerializedName;

public class AllowRequest {

    @SerializedName("key")
    private String key;

    @SerializedName("auth_token")
    private String authToken;

    public AllowRequest() { }

    public AllowRequest(String key, String authToken) {
        this.key = key;
        this.authToken = authToken;
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
}
