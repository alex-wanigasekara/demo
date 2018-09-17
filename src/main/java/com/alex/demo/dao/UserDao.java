package com.alex.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.demo.domain.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
