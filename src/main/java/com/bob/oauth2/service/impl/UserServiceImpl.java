package com.bob.oauth2.service.impl;

import com.bob.oauth2.dao.UserDao;
import com.bob.oauth2.model.Users;
import com.bob.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Users users = userDao.findByUsername(userId);
		if(users == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Users> findAll() {
		List<Users> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Users findOne(long id) {
		return userDao.findById(id).get();
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
    public Users save(Users users) {
        return userDao.save(users);
    }
}
