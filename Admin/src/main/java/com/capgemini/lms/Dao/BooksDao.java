package com.capgemini.lms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;

@Repository
public interface BooksDao extends JpaRepository<Books, Integer> {

}
