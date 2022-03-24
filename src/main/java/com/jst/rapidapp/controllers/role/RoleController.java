package com.jst.rapidapp.controllers.role;


import com.jst.rapidapp.beans.Role;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.service.role.RoleService;
import com.jst.rapidapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapidapp/role")
public class RoleController {

    @Autowired
    RoleService roleService;



    @PostMapping("/create")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        Role roleResponse = roleService.createRole(role);
        return new ResponseEntity<Role>(roleResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getUserById(@PathVariable long roleId){
        System.out.println("role##"+roleId);
        Role role = roleService.findRoleById(roleId);
        if(role==null){
            return new ResponseEntity<Role>(role,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Role>(role,HttpStatus.OK);
    }

}
