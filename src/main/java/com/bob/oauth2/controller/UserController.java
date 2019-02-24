package com.bob.oauth2.controller;

import com.bob.oauth2.model.Users;
import com.bob.oauth2.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<Users> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Users create(@RequestBody Users users){
        return userService.save(users);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Users findOne(@PathVariable long id){
        return userService.findOne(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Users update(@PathVariable long id, @RequestBody Users users){
        users.setId(id);
        return userService.save(users);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
    }

}
