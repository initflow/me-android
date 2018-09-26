package io.forus.me.android.data.entity.applogin;

import com.google.gson.annotations.SerializedName;

public class CreateLoginResponse {

    @SerializedName("token")
    private String token;

    public CreateLoginResponse() { }

    public CreateLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
