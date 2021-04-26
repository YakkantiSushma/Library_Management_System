package com.capgemini.lms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.capgemini.lms.entities.BooksIssued;

@Repository
public interface BooksIssuedDao extends JpaRepository<BooksIssued, Integer> {

}
