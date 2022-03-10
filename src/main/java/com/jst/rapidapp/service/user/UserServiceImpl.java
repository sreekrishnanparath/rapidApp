package com.jst.rapidapp.service.user;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.module.ModuleDAO;
import com.jst.rapidapp.dao.user.UserDAO;
import com.jst.rapidapp.service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User createUserMaster(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    @Override
    public User findUserByEmailIdAndPassword(String userEmail, String password) {
        return userDAO.getUserByEmailAndPassword(userEmail,password);
    }
    @Override
    public List<User>  getAllUsers()
    {
        return userDAO.getUsers();
    }
    @Override
    public void deleteUserById(long id) {
        userDAO.deleteUserById(id);
    }
    @Override
    public User updateUser(User user,long userId) {
        return userDAO.updateUser(user,userId);
    }




}
