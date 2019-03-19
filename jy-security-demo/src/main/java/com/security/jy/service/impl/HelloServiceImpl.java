package com.security.jy.service.impl;

import com.security.jy.service.Helloservice;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements Helloservice {

    @Override
    public void hello(String name) {
        System.out.println("hello , "+name);
    }
}
