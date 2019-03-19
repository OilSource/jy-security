package com.security.jy.core.validate.sms.config;

import com.security.jy.core.properties.SecurityProperties;
import com.security.jy.core.validate.generator.DefaultSmsCodeGenerator;
import com.security.jy.core.validate.generator.ValidateCodeGenerator;
import com.security.jy.core.validate.sms.send.DefaultSmsCodeSender;
import com.security.jy.core.validate.sms.send.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateSmsCodeBeanConfig {

    @Autowired
    SecurityProperties securityProperties;


    @Bean("smsCodeGenerator")
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        DefaultSmsCodeGenerator generator=new DefaultSmsCodeGenerator();
        generator.setSecurityProperties(securityProperties);
        return generator;
    }

    @Bean()
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender(){
        return new DefaultSmsCodeSender();
    }
}
