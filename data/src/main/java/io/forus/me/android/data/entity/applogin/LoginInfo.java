package io.forus.me.android.data.entity.applogin;

import com.google.gson.annotations.SerializedName;

public class LoginInfo {

    public class Organization{

        @SerializedName("title")
        private String title;

        @SerializedName("owner")
        private String owner;

        @SerializedName("public_key")
        private String publicKey;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }
    }

    @SerializedName("key")
    private String key;

    @SerializedName("status")
    private String status;

    @SerializedName("auth_token")
    private String authToken;

    @SerializedName("data")
    private String data;

    @SerializedName("organization")
    private Organization organization;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
