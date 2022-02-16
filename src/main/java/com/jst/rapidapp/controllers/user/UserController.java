package com.jst.rapidapp.controllers.user;


import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rapidapp/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/welcome")
    public ResponseEntity<User> getTestData() {
        User user = new User(1, "Sree", "Krishnan", 29);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User userResponse = userRepository.saveAndFlush(user);
        return new ResponseEntity<User>(userResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId){
        System.out.println("User##"+userId);
        User user = userRepository.findById(userId);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

}
