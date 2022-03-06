package com.gloria.moringacrud.dataLayer.repositories;

import com.gloria.moringacrud.dataLayer.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReopsitory extends CrudRepository<User,Long> {
        User findByUsername(String username);
    }


