package com.jst.rapidapp.service.role;


import com.jst.rapidapp.beans.Role;
import com.jst.rapidapp.beans.User;

import java.util.List;

public interface RoleService {

    public Role createRole(Role role);
    public Role findRoleById(long id);

}
