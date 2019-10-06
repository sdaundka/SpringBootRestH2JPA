package com.demorestapp.resource.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demorestapp.resource.entities.User;

public interface UserH2Repository extends JpaRepository<User, Integer> {

}
