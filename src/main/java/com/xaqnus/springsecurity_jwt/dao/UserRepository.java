package com.xaqnus.springsecurity_jwt.dao;

import com.xaqnus.springsecurity_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
