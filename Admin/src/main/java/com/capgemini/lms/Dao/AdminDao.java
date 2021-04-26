package com.capgemini.lms.Dao;

import java.util.List;
import java.util.concurrent.Flow.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Admin;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.entities.Feedback;
import com.capgemini.lms.entities.Users;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {

//	Books save(Books books);
//	BooksOrder save(BooksOrder ordered);
//	BooksOrder delete(BooksOrder ordered);
//	Publisher save(Publisher publisher);
//	Publisher delete(Publisher publisher);
//	List<DamagedBooks> findAll(DamagedBooks damagedbooks);
//	Feedback save(Feedback feedback);
//	Users findByUserId(int userid);
//	Users save(Users user1);



}
