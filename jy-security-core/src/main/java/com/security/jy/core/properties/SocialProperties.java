package com.security.jy.core.properties;

public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    private QQSocialProperties qq = new QQSocialProperties();

    public QQSocialProperties getQq() {
        return qq;
    }

    public void setQq(QQSocialProperties qq) {
        this.qq = qq;
    }

    public String getFilterProcessesUrl() {
        return filterProcessesUrl;
    }

    public void setFilterProcessesUrl(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }
}
