package com.security.jy.core.properties;

public class OAuth2Properties {

    private String jwtSigningKey = "jy";

    private String storeType = "jwt";

    private OAuth2ClientProperties[] client ={};

    public OAuth2ClientProperties[] getClient() {
        return client;
    }

    public void setClient(OAuth2ClientProperties[] client) {
        this.client = client;
    }

    public String getJwtSigningKey() {
        return jwtSigningKey;
    }

    public void setJwtSigningKey(String jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }
}
