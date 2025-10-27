package com.example.jdbc.batch;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class PatientDao {

    private JdbcTemplate jdbcTemplate;

    // Constructor to receive the JdbcTemplate from the Spring context
    public PatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int[] batchInsert(List<Patient> patients) {
        
        String sql = "INSERT INTO patients(name, age, disease) VALUES (?, ?, ?)";

        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            // This method is called for each item in the list
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Patient patient = patients.get(i);
                ps.setString(1, patient.getName());
                ps.setInt(2, patient.getAge());
                ps.setString(3, patient.getDisease());
            }

            // This method returns the total number of records to be inserted
            public int getBatchSize() {
                return patients.size();
            }
        });
    }
}