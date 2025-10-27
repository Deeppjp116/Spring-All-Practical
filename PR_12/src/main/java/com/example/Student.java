package com.example;

public class Student {
    private String name = "Deep";
    private int age = 21;

    // --- Getters and Setters are required for SpEL to access properties ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}