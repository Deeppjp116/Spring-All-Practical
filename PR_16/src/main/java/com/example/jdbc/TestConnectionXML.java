package com.example.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestConnectionXML {

    public static void main(String[] args) {
        
        // 1. Load the Spring configuration file from the classpath (src/main/resources)
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("jdbc-config.xml");
        
        // 2. Get the JdbcTemplate bean from the Spring container
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        // 3. Execute a simple query
        //    queryForObject is used when you expect exactly one result
        String now = jdbcTemplate.queryForObject("SELECT NOW()", String.class);
        
        // 4. Print the result
        System.out.println("Current Time from DB: " + now);
        
        // Close the context (good practice)
        ((ClassPathXmlApplicationContext) context).close();
    }
}