package com.example.securitydemo;

import com.example.securitydemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {
}
