package com.capgemini.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.Dao.UsersDao;
import com.capgemini.lms.entities.Users;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UsersDao userDao;

	@Override
	public Users register(Users user) {
		return userDao.save(user);
	}

	@Override
	public List<Users> viewAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Users updateUserDetails(Users user) {
		return userDao.save(user);
	}

	@Override
	public void deleteUser(int id) {
//		List<Users> users = userDao.findAll();
//		Users user = userDao.findById(id).get();
//        users.remove(user);
		 userDao.deleteById(id);
	}

}
