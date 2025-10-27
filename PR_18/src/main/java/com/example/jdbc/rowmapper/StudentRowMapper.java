package com.example.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        // Create a new Student object for this row
        Student s = new Student();
        
        // Extract data from the ResultSet and set it in the Student object
        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setDepartment(rs.getString("department"));
        
        return s;
    }
}