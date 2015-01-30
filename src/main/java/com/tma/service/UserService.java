package com.tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tma.dao.UserDao;
import com.tma.model.User;

@Component
public class UserService implements UserServiceImpl {
	private UserDao userRepository;

	@Autowired
	public UserService(UserDao userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
		// return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getWithId(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(String id, User user) {
		if (userRepository.findOne(id) != null) {
			userRepository.save(user);
		}
	}

	@Override
	public void delete(String id) {
		userRepository.delete(id);
	}

}
