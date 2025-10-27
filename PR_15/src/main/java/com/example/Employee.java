package com.example;

public class Employee {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Optional: Add a toString() for easy printing
    @Override
    public String toString() {
        return "Employee [salary=" + salary + "]";
    }
}