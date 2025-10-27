package com.example.jdbc.rowmapper;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springdb");
        ds.setUsername("root");
        
        //
        // !!!!!!!!!!!!!  IMPORTANT !!!!!!!!!!!!!
        // Update this with the new password you set in the terminal
        //
        ds.setPassword("deep"); // <-- CHANGE THIS!
        
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        // Spring will automatically pass the 'dataSource' bean created above
        return new JdbcTemplate(dataSource());
    }
}