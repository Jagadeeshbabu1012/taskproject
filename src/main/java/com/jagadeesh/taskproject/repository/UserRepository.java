package com.jagadeesh.taskproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jagadeesh.taskproject.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
