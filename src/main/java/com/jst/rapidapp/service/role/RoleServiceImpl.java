package com.jst.rapidapp.service.role;


import com.jst.rapidapp.beans.Role;
import com.jst.rapidapp.dao.role.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO roleDAO;


    @Override
    public Role createRole(Role role) {
        return roleDAO.saveRole(role);
    }

    @Override
    public Role findRoleById(long id) {
        return roleDAO.getUserById(id);
    }
}
