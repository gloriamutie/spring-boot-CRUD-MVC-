package com.gloria.moringacrud.service;

import com.gloria.moringacrud.dataLayer.User;
import com.gloria.moringacrud.dataLayer.dto.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}