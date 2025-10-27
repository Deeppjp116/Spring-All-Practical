package jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestConnectionXML {

    public static void main(String[] args) {
        
        // 1. Load the Spring XML configuration
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("jdbc-config.xml");
        
        // 2. Get the JdbcTemplate bean
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        // 3. THIS IS THE QUERY YOU ASKED FOR
        String now = jdbcTemplate.queryForObject("SELECT NOW()", String.class);
        
        // 4. Print the result
        System.out.println("Current Time from DB: " + now);
        
        ((ClassPathXmlApplicationContext) context).close();
    }
}