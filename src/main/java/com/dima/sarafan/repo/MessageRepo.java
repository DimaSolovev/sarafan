package com.dima.sarafan.repo;

import com.dima.sarafan.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
