package com.bob.oauth2.service;

import com.bob.oauth2.model.Users;

import java.util.List;

public interface UserService {

    Users save(Users users);

    List<Users> findAll();

    Users findOne(long id);

    void delete(long id);
}
