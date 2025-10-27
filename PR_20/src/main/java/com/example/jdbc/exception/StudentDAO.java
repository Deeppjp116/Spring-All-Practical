package com.example.jdbc.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertStudent(int id, String name) {
        try {
            String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
            jdbcTemplate.update(sql, id, name);
            System.out.println("Student inserted successfully");
        
        // This catch block handles all Spring JDBC exceptions
        } catch (DataAccessException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}