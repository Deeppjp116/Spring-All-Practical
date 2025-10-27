package com.example.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        
        // 1. Load the Spring configuration
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("beans.xml");

        // 2. Get the DAO bean from the Spring container
        StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");

        // 3. Create a new Student object
        Student student = new Student();
        student.setId(1);
        student.setName("John Doe");
        student.setCourse("Java");
        student.setFee(10000);

        // 4. Call the insert method
        studentDAO.insert(student);

        System.out.println("Record inserted successfully!");
        
        ((ClassPathXmlApplicationContext) context).close();
    }
}