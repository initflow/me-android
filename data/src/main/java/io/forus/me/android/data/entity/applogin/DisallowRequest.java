package io.forus.me.android.data.entity.applogin;

import com.google.gson.annotations.SerializedName;

public class DisallowRequest {

    @SerializedName("key")
    private String key;

    public DisallowRequest() { }

    public DisallowRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
