package com.proj.project1.repository;

import com.proj.project1.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJp extends JpaRepository<User, Long> {
}
