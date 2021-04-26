package com.capgemini.lms.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer>{
// public Users findByUser(Users users);

	
	
	
	
}
