package com.bob.oauth2.dao;

import com.bob.oauth2.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
