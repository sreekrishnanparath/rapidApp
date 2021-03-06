package com.jst.rapidapp.service.user;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;

import java.util.List;

public interface UserService {

    public User createUserMaster(User user);

    public User findUserMasterById(long id);
    public List<User> findUserByCompanyId(long id);
    public User findUserByEmailId(String userEmail);
    public User findUserByEmailIdAndPassword(String userEmail,String password);
    public void deleteUserById(long id);
    public List<User>  getAllUsers();
    public User updateUser(User user,long userId);

}
