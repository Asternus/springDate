package com.proj.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserJp userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public List<User> getAll(String s) {
        return userRepository.searchUsersByKeyword(s);
    }

    public void updateUserEmail(String s, int id) {
        userRepository.updateUserEmail(s, id);
    }

    public List<User> getAllWihGender(int age, String gender) {
        return userRepository.findUsersByAgeAndGender(age, gender);
    }

}
