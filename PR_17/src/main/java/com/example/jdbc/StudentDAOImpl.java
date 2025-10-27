package com.example.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImpl implements StudentDAO {
    
    private JdbcTemplate jdbcTemplate;

    // Setter for JdbcTemplate (used for injection)
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Implementation of the insert method
    public void insert(Student student) {
        String sql = "INSERT INTO students (id, name, course, fee) VALUES (?, ?, ?, ?)";
        
        // Use jdbcTemplate.update() for INSERT, UPDATE, DELETE
        jdbcTemplate.update(sql, 
                            student.getId(), 
                            student.getName(), 
                            student.getCourse(), 
                            student.getFee());
    }
}