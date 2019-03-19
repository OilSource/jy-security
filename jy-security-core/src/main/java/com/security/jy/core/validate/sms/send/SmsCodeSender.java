package com.security.jy.core.validate.sms.send;

public interface SmsCodeSender {

    void send(String mobile,String code);
}
