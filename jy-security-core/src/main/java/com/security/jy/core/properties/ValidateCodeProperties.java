package com.security.jy.core.properties;

public class ValidateCodeProperties {

    private ImageProperties image = new ImageProperties();

    private SmsProperties sms = new SmsProperties();

    public ImageProperties getImage() {
        return image;
    }

    public void setImage(ImageProperties image) {
        this.image = image;
    }

    public SmsProperties getSms() {
        return sms;
    }

    public void setSms(SmsProperties sms) {
        this.sms = sms;
    }
}
