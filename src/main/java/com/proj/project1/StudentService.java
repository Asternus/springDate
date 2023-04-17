package com.proj.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentByEmail(final String email) {
        return studentRepo.findStudentByEmail(email).orElse(null);
    }

    @Transactional
    public void saveStudent(final Student student) {
        studentRepo.save(student);
    }


    public List<Student> getWithOrder(final int age) {
        return studentRepo.findAllByAgeAfterOrderByAgeDesc(age);
    }

    public Student getLast(final int age) {
        return studentRepo.findAllByAgeAfterOrderByAgeDesc(age).get(0);
    }

    public List<Student> getWithKeyWord(final String key) {
        return studentRepo.searchStudentsByKeyword(key);
    }

    public List<String> getSecondNames(final int age) {
        return studentRepo.searchSecondNames(age);
    }

    public void updateStudent(final String email, final int id) {
        studentRepo.updateStudentEmail(email, id);
    }

}
