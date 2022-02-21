package com.jst.rapidapp.controllers.user;


import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.repository.user.UserRepository;
import com.jst.rapidapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User userResponse = userService.createUserMaster(user);
        return new ResponseEntity<User>(userResponse,HttpStatus.CREATED);
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<User> getUserById(@PathVariable long userId){
//        System.out.println("User##"+userId);
//        User user = userService.findUserMasterById(userId);
//        if(user==null){
//            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user,HttpStatus.OK);
//    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<User> getUserByEmailId(@PathVariable String userEmail){
        System.out.println("User##"+userEmail);
        User user = userService.findUserByEmailId(userEmail);
        if(user==null){
            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> doLogin(@RequestBody User user){
        User userResponse = userService.findUserByEmailIdAndPassword(user.getUserEmail(),user.getPassword());
        if(userResponse==null){
            return new ResponseEntity<User>(userResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(userResponse,HttpStatus.OK);
    }

}
