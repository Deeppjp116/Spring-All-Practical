package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


public class BeanExpressionDemo {

    public static void main(String[] args) {
        // 1. Load the Spring container, which reads beans.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 2. Create a SpEL parser
        ExpressionParser parser = new SpelExpressionParser();

        // 3. Get the "student" bean from the container
        Student student = context.getBean("student", Student.class);

        // 4. Create an EvaluationContext and set the 'student'
        //    object as the root object.
        EvaluationContext evalContext = new StandardEvaluationContext(student);

        // 5. Parse the expression "name". SpEL will look for a 
        //    'name' property (i.e., a getName() method) on the root object.
        String name = parser.parseExpression("name").getValue(evalContext, String.class);

        // 6. Print the result
        System.out.println("Student Name: " + name);
    }
}