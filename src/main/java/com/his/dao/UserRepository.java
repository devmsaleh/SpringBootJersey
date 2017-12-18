package com.his.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
