package io.forus.me.android.data.entity.applogin;

import com.google.gson.annotations.SerializedName;

public class CreateLoginRequest {

    @SerializedName("public_key")
    private String publicKey;

    public CreateLoginRequest() { }

    public CreateLoginRequest(String publicKey) {
        this.publicKey = publicKey;
    }

    public String isPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
