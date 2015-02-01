package com.tma.service;

import java.util.List;

import com.tma.model.User;

public interface IUserService {
	public List<User> getAll();
	public User getWithId(String id);
	public void addUser(User user);
	public void update(String id,User user);
	public void delete(String id);
}
