package com.capgemini.lms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.BooksReturned;

@Repository
public interface BooksReturnedDao extends JpaRepository<BooksReturned, Integer> {

}
