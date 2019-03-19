package com.security.jy.validator;

import com.security.jy.service.Helloservice;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    Helloservice helloservice;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloservice.hello("xiaomi");
        System.out.println("isValid :"+ o);
        return false;
    }
}
