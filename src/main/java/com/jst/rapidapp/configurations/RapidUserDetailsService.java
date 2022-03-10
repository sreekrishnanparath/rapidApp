package com.jst.rapidapp.configurations;

import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RapidUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles = null;
        User userinfo = userRepository.findByUserEmail(user);

        if(userinfo!=null) {
            return new RapidUserDetails(userinfo);
        }
        throw new UsernameNotFoundException("Not a valid User!" + user);
    }
}
