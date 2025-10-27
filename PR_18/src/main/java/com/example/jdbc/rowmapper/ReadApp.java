package com.example.jdbc.rowmapper;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReadApp {

    public static void main(String[] args) {
        
        // 1. Load the Spring configuration from the Java class
        ApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Get the JdbcTemplate bean
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        // 3. Define the query
        String query = "SELECT * FROM student";

        // 4. Execute the query using the RowMapper
        List<Student> students = jdbcTemplate.query(query, new StudentRowMapper());

        // 5. Loop through the results and print them
        for (Student s : students) {
            System.out.println(s.getId() + ", " + s.getName() + ", " + s.getDepartment());
        }

        // 6. Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}