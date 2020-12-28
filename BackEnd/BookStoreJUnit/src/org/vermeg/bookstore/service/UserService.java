package org.vermeg.bookstore.service;


import java.util.List;

import org.vermeg.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")

public class UserService {

	@Autowired
	org.vermeg.bookstore.dao.UserDao UserDao;
	
	@Transactional
	public List<User> getAllUsers() {
		return UserDao.getAllUsers();
	}

	@Transactional
	public User getUser(int id) {
		return UserDao.getUser(id);
	}

	@Transactional
	public void addUser(User User) {
		UserDao.addUser(User);
	}

	@Transactional
	public void updateUser(User User) {
		UserDao.updateUser(User);

	}

	@Transactional
	public void deleteUser(int id) {
		UserDao.deleteUser(id);
	}
}

