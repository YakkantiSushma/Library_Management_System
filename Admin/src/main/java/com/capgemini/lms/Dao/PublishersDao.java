package com.capgemini.lms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Publishers;

@Repository
public interface PublishersDao extends JpaRepository<Publishers, Integer> {

}
