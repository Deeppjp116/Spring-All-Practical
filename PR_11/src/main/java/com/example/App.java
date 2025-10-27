package com.example; // Make sure this matches your pom.xml groupId

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class App {

    public static void main(String[] args) {
        // 1. Create a new instance of the SpEL parser
        ExpressionParser parser = new SpelExpressionParser();

        // 2. Parse the expression
        //
        // IMPORTANT CORRECTION:
        // To define a string literal *inside* SpEL, you must use
        // single quotes (''). Your original code (""Welcome to SpEL")
        // would look for a property named "Welcome to SpEL", which isn't what you want.
        //
        // The correct expression is "'Welcome to SpEL'"
        //
        String expressionString = "'Welcome to SpEL'";
        
        // 3. Get the value of the parsed expression
        // We tell getValue() we expect a String back
        String message = parser.parseExpression(expressionString).getValue(String.class);

        // 4. Print the result
        System.out.println("Message: " + message);
    }
}