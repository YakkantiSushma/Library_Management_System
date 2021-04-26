package com.capgemini.lms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.UserAddress;

@Repository
public interface UserAddressDao extends JpaRepository<UserAddress, Integer> {

}
