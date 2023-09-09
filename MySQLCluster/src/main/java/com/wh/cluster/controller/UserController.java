package com.wh.cluster.controller;

import com.wh.cluster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public Object getAll(){
        return userService.getAll();
    }

    @GetMapping("insertOne")
    public void insertOne(){
        userService.insertOne();
    }

    @GetMapping("readAndWrite")
    public void readAndWrite(){
        userService.testReadAndWrite();
    }

    @GetMapping("transInsert")
    public void transInsert(){
        userService.transInsert();
    }

}
