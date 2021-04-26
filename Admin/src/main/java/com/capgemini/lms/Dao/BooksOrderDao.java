package com.capgemini.lms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.BooksOrder;

@Repository
public interface BooksOrderDao extends JpaRepository<BooksOrder, Integer>{
}