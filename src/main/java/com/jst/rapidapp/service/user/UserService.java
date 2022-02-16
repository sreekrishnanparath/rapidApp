package com.jst.rapidapp.service.user;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;

import java.util.List;

public interface UserService {


    public User createUserMaster(User user);
    public User updateUserMaster(long id, User user);
    public void deleteUserMaster(long id);
    public List<User> getAllUserMaster();
    public User findUserMasterById(long id);
    public List<User> findUserByCompanyId(long id);
    public User findUserByEmailId(String userEmail);
}
