package com.security.jy.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello , springSecurity";
    }
}
