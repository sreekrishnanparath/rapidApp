package com.jst.rapidapp.controllers.user;


import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.beans.configuration.GenericResponse;
import com.jst.rapidapp.exception.NoDataFoundException;
import com.jst.rapidapp.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapidapp/user")
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/welcome")
//    public ResponseEntity<User> getTestData() {
//        User user = new User(1, "Sree", "Krishnan", 29,"");
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }

    @Operation(summary = "User endpoint")
    @PostMapping("/create")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        System.out.println("User## create"+user.getUserEmail());
        User userResponse = userService.createUserMaster(user);
        return new ResponseEntity<User>(userResponse,HttpStatus.CREATED);
    }

    @GetMapping("/id/{userId}")
    public GenericResponse<User> getUserById(@PathVariable long userId){
        System.out.println("User##"+userId);
        User user = userService.findUserMasterById(userId);
        if(user==null){
            throw new NoDataFoundException("User Not Found!");
        }
        return new GenericResponse<User>(HttpStatus.CREATED,user,"");
    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<User> getUserByEmailId(@PathVariable String userEmail){
        System.out.println("User##"+userEmail);
        User user = userService.findUserByEmailId(userEmail);
        if(user==null){
            throw new NoDataFoundException("User Not Found!");
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> doLogin(@RequestBody User user){
        System.out.println(user.getUserEmail());
        System.out.println(user.getPassword());
        User userResponse = userService.findUserByEmailIdAndPassword(user.getUserEmail(),user.getPassword());
        if(userResponse==null){
            return new ResponseEntity<User>(userResponse,HttpStatus.NOT_FOUND);
        }
        System.out.println(userResponse);
        return new ResponseEntity<User>(userResponse,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        userService.deleteUserById(userId);
//        List<User> users = userService.getAllUsers();
        return new ResponseEntity<String>("Sucessfully deleted",HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity <List<User>> getAllUsers(){
//        System.out.println("get all user");
//        System.out.println(userService.getAllUsers());
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public  ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable long userId)
    {
//        System.out.println(user);
            return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
    }
}
