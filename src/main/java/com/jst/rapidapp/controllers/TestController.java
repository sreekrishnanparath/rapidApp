package com.jst.rapidapp.controllers;


import com.jst.rapidapp.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rapidapp/test")
public class TestController {

//    @Autowired
//    User user;
//
//    @GetMapping("/welcome")
//    public ResponseEntity<User> getTestData() {
//        user = new User(1, "Sree", "Krishnan", 29);
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }


}
