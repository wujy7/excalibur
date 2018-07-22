package com.jd.excalibur.controller.user;

import com.jd.excalibur.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/user" )
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public Object selectUser (){
        return userService.getUserCount();
    }

}
