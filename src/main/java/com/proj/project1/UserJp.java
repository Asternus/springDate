package com.proj.project1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserJp extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.firstName LIKE %:keyword% OR u.lastName LIKE %:keyword% OR u.email LIKE %:keyword%")
    List<User> searchUsersByKeyword(String keyword);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.email = ?1 WHERE u.id = ?2")
    void updateUserEmail(String email, Integer id);

    @Query("SELECT u FROM User u WHERE u.age >= :age AND u.gender = :gender")
    List<User> findUsersByAgeAndGender(int age, String gender);

}
