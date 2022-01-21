package com.nirsb.account.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nirsb.account.model.dto.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{

}
