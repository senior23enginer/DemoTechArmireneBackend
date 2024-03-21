package com.armirene.demotech.controller;

import com.armirene.demotech.entity.Users;
import com.armirene.demotech.model.StudentModel;
import com.armirene.demotech.service.StudentService;
import com.armirene.demotech.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createStudent(@RequestBody Users request ){
        return usersService.createUser(request);
    }
}
