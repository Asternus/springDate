package com.proj.project1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.proj.project1");
        final StudentService studentService = applicationContext.getBean("studentService", StudentService.class);

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            final int age = random.nextInt(17, 30);

            final Student student = new Student();

            student.setAge(age);
            if (i % 2 == 0) {
                student.setFirstName("user" + i);
                student.setSecondName("user" + i);
            } else {
                student.setFirstName("Student" + i);
                student.setSecondName("Second" + i);
            }
            student.setEmail(student.getFirstName() + "@gmail.com");

            studentService.saveStudent(student);
        }

   /*     final List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(System.out::println);*/

    /*    final Student studentByEmail = studentService.getStudentByEmail("Student1@gmail.com");
        System.out.println(studentByEmail);*/


        studentService.updateStudent("cat@gmail.com", 6);

        final List<Student> withOrder = studentService.getWithOrder(14);
        withOrder.forEach(System.out::println);

   /*     final Student last = studentService.getLast(14);

        System.out.println("last" + last);*/

        System.out.println("----------------------------------------------------");

      /*  final List<Student> student = studentService.getWithKeyWord("Student");
        student.forEach(System.out::println);*/



      /*  final List<String> student1 = studentService.getSecondNames(14);
        student1.forEach(System.out::println);*/




    }

}
