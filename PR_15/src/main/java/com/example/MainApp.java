package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // 1. Load the Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 2. Get the bean from the Spring container
        // Spring has already created this object and set its properties
        Employee emp = context.getBean("employee", Employee.class);

        // 3. Print the salary to verify
        System.out.println("Salary: " + emp.getSalary());
        
        // 4. (Optional) Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}