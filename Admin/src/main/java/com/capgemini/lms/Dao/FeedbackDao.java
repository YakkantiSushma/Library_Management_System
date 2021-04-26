package com.capgemini.lms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.entities.Users;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
	public Feedback findByUser(Users user);


}
