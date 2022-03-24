package com.jst.rapidapp.repository.role;


import com.jst.rapidapp.beans.Role;
import com.jst.rapidapp.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role saveAndFlush(User user);

    Role findById(long id);

//    Role findByUserEmail(String userEmail);
//
//    Role findUserByUserEmailAndPassword(String userEmail,String password);
//
//    Role <User> findAll();
//
//    Role deleteById(long id);


}
