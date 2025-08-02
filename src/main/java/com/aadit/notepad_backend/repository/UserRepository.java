package com.aadit.notepad_backend.repository;

import com.aadit.notepad_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
