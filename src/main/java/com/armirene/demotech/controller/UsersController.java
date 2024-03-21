package com.armirene.demotech.controller;

import com.armirene.demotech.document.UsersSalesForce;
import com.armirene.demotech.entity.Users;
import com.armirene.demotech.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Users createUser( @RequestBody Users request ){
        return usersService.createUser(request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Users updateUser( @RequestBody Users request ){
        return usersService.updateUser(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users getUser( @PathVariable("id") int id){
        return usersService.getUser(id);
    }

    @RequestMapping(value = "/user-sales/{id}", method = RequestMethod.GET)
    public UsersSalesForce getUserSalesForce(@PathVariable("id") String id ){
        return usersService.getUserSalesForce(id);
    }
}
