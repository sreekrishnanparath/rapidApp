package com.jst.rapidapp.repository.user;


import com.jst.rapidapp.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {

    User saveAndFlush(User user);

    User findById(long id);

    User findByUserEmail(String userEmail);

    User findByUserName(String userName);

    User findUserByUserEmailAndPassword(String userEmail,String password);

    List <User> findAll();

    User deleteById(long id);


}
