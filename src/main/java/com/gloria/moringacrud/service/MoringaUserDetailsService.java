package com.gloria.moringacrud.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoringaUserDetailsService implements UserDetailsService {
//springsecurity class calls this service class and request for user with the collected userName
    //Spring framework calls this method inorder to load a user by userName
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //
        return new User("name","password",new ArrayList<>());
    }
}
