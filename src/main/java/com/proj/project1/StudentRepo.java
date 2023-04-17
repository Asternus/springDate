package com.proj.project1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentRepo extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentByEmail(String email);

    List<Student> findAllByAgeAfterOrderByAgeDesc(final int age);

    @Query("SELECT u FROM Student u WHERE u.firstName LIKE %:keyword% OR u.secondName LIKE %:keyword% OR u.email LIKE %:keyword%")
    List<Student> searchStudentsByKeyword(String keyword);

    @Query("SELECT u.secondName FROM Student u WHERE u.age >= :age")
    List<String> searchSecondNames(int age);

    @Transactional
    @Modifying
    @Query("UPDATE Student u SET u.email = ?1 WHERE u.id = ?2")
    void updateStudentEmail(String email, Integer id);

}
