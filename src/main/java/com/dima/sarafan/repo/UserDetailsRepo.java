package com.dima.sarafan.repo;

import com.dima.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
