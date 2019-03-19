package com.security.jy.core.validate.generator;

import com.security.jy.core.validate.sms.model.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {

    ValidateCode generator(ServletWebRequest request);
}
