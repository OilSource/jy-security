package com.security.jy.core.validate.generator;

import com.security.jy.core.properties.SecurityProperties;
import com.security.jy.core.validate.code.model.ImageCode;
import com.security.jy.core.validate.sms.model.ValidateCode;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DefaultSmsCodeGenerator implements ValidateCodeGenerator {
    SecurityProperties securityProperties;

    @Override
    public ValidateCode generator(ServletWebRequest request) {
        String code =RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
