package com.jst.rapidapp.dao.user;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.repository.module.ModuleRepository;
import com.jst.rapidapp.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {


    @Autowired
    UserRepository userRepository;


    public User saveUserMaster(User user){

        return userRepository.saveAndFlush(user);
    }

    public User getUserById(long id){
        return userRepository.findById(id);
    }


    public User getUserByEmail(String userEmail){
        return userRepository.findByUserEmail(userEmail);
    }

    public User getUserByEmailAndPassword(String userEmail,String password){
        return userRepository.findUserByUserEmailAndPassword(userEmail,password);
    }
    //delete user by id
    public void deleteUserById(long userId)
    {
        userRepository.deleteById(userId);
    }
    //find all user
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    //will only update firstname and lastname
    public User updateUser(User user,long userId)
    {
        User existUser = userRepository.findById(userId);
        existUser.setUserName(user.getUserName());
        existUser.setLastName(user.getLastName());
        existUser.setPassword(user.getPassword());
        userRepository.saveAndFlush(existUser);
        System.out.println("existUser::"+existUser);
        return existUser;
    }

}
