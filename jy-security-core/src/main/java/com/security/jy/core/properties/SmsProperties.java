package com.security.jy.core.properties;

public class SmsProperties {


    private int length = 6;

    private long expireIn = 60;

    private String url ;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getExpireIn() {
        return expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setExpireIn(long expireIn) {
        this.expireIn = expireIn;
    }
}
