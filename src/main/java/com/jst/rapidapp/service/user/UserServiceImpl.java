package com.jst.rapidapp.service.user;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.module.ModuleDAO;
import com.jst.rapidapp.dao.user.UserDAO;
import com.jst.rapidapp.service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;


    @Override
    public User createUserMaster(User user) {
        return userDAO.saveUserMaster(user);
    }

    @Override
    public User updateUserMaster(long id, User user) {
        return null;
    }

    @Override
    public void deleteUserMaster(long id) {

    }

    @Override
    public List<User> getAllUserMaster() {
        return null;
    }

    @Override
    public User findUserMasterById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> findUserByCompanyId(long id) {
        return null;
    }

    @Override
    public User findUserByEmailId(String userEmail) {
        return userDAO.getUserByEmail(userEmail);
    }
}
