package com.jst.rapidapp.dao.role;


import com.jst.rapidapp.beans.Role;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.repository.role.RoleRepository;
import com.jst.rapidapp.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleDAO {

    @Autowired
    RoleRepository roleRepository;


    public Role saveRole(Role role){
        return roleRepository.saveAndFlush(role);
    }

    public Role getUserById(long id){
        return roleRepository.findById(id);
    }




}
