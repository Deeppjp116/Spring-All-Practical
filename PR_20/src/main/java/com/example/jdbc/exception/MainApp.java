package com.example.jdbc.exception;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        
        // 1. Load the Spring Java configuration
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Get the StudentDAO bean
        StudentDAO dao = context.getBean(StudentDAO.class);

        // 3. Try inserting the first student (should work)
        System.out.println("---- Attempt 1 ----");
        dao.insertStudent(1, "Ravi");

        // 4. Try inserting a student with the same ID to trigger an exception
        System.out.println("---- Attempt 2 ----");
        dao.insertStudent(1, "Ravi Duplicate");
        
        // 5. Close the context
        context.close();
    }
}