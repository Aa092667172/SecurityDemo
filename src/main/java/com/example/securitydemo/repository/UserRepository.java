package com.example.securitydemo.repository;

import com.example.securitydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author Kevin  on 2023/10/29
 */
public interface UserRepository extends JpaRepository<User,Integer> {
  Optional<User> findByEmail(String email);
}
