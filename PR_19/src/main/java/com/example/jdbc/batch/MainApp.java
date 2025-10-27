package com.example.jdbc.batch;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApp {

    public static void main(String[] args) {
        
        // 1. Load the Spring Java configuration
        AnnotationConfigApplicationContext ctx = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Get the JdbcTemplate bean and create the DAO
        PatientDao dao = new PatientDao(ctx.getBean(JdbcTemplate.class));

        // 3. Create a list of new patients
        List<Patient> patients = Arrays.asList(
            new Patient("Ravi", 25, "Fever"),
            new Patient("Neha", 30, "Cold"),
            new Patient("Amit", 45, "Diabetes")
        );

        // 4. Execute the batch insert
        int[] result = dao.batchInsert(patients);

        // 5. Print the result (an array of '1's, one for each successful insert)
        System.out.println("Inserted Rows: " + Arrays.toString(result));

        // 6. Close the context
        ctx.close();
    }
}