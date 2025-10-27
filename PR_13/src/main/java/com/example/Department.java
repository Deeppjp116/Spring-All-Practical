package com.example;

public class Department {

    // Correct way to initialize an array field
    private String[] employees = {"John", "Deep", "David"};

    // Getter is required for SpEL to access the 'employees' property
    public String[] getEmployees() {
        return employees;
    }

    public void setEmployees(String[] employees) {
        this.employees = employees;
    }
}
