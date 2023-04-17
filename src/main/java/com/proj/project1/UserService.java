package com.proj.project1.service;

import com.proj.project1.repository.UserJp;
import com.proj.project1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserJp userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public List<User> findByFirstName() {
        return userRepository.findAll();
    }

}
