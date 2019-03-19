package com.security.jy.core.social.config;

import com.security.jy.core.properties.SecurityProperties;
import com.security.jy.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
@Configuration
@ConditionalOnProperty(prefix = "jy.security.social.qq",name = "app-id")
public class SocialAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new QQConnectionFactory(securityProperties.getSocial().getQq().getProviderId(),
                securityProperties.getSocial().getQq().getAppId(),
                securityProperties.getSocial().getQq().getAppSecret());
    }
}
