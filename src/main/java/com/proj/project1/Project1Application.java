package com.proj.project1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Project1Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.proj.project1");
        final UserService userService = applicationContext.getBean("userService", UserService.class);
        final User user = new User();
        user.setType("Studnet");
        user.setFirstName("Lisa");
        user.setAge(10);
        user.setGender("Female");
        userService.saveUser(user);

        userService.updateUserEmail("cat", 1);

        final List<User> lisa = userService.getAll("Lisa");

        System.out.println(lisa);

        System.out.println(userService.getAllWihGender(10, "Female"));
    }

}
