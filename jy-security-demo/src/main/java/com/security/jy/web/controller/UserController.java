package com.security.jy.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.security.jy.core.properties.SecurityProperties;
import com.security.jy.dto.User;
import com.security.jy.exception.UserNotExistException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping("/me")
    public Object getCurrentUser(Authentication user, HttpServletRequest request) throws Exception {
        String header = request.getHeader("Authorization");
        String token = StringUtils.substringAfter(header,"bearer  ");
        Claims claims= Jwts.parser().setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
                .parseClaimsJws(token).getBody();
        System.out.println(claims.get("company"));
        return user;
    }


    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user) {

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId(1);
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(
                    error-> {
//                        FieldError fieldError = (FieldError) error;
//                        String message = fieldError.getField() + "  "+ fieldError.getDefaultMessage();
//                        System.out.println(message);
                        System.out.println(error.getDefaultMessage());
                    }
            );
        }
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(){
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping("/error")
    public void error() throws Exception {
        throw new UserNotExistException("aaaa");

    }

    @GetMapping("/runTimeError")
    @ResponseBody
    public void runTimeError() throws Exception {
        throw new RuntimeException("运行错误");

    }
}
