package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ArrayAccessDemo {

    public static void main(String[] args) {
        // 1. Create the parser
        ExpressionParser parser = new SpelExpressionParser();
        
        // 2. Load the Spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 3. Get the "department" bean
        Department dept = context.getBean("department", Department.class);

        // 4. Create an EvaluationContext with the 'dept' object as the root
        EvaluationContext evalContext = new StandardEvaluationContext(dept);

        // 5. Use SpEL to access the property "employees" and then
        //    the element at index 1. This calls dept.getEmployees()[1].
        String emp = parser.parseExpression("employees[1]").getValue(evalContext, String.class);

        // 6. Print the result
        System.out.println("Employee: " + emp);
    }
}