package com.java.dsa.stacks;

import java.util.Stack;

public class ConvertPostfixToPrefix {
    /*
        Algorithm:
        - Read the postfix expression from left to right
        - If the symbol is an operand, then push it into the stack
        - If the symbol is an operator, then pop two operands from the stack
        - Create a string by concatenating the two operands and operator before them
            string = operator + operand2 + operand1
            and push the resultant string back to stack
        - Repeat the above steps until end of the postfix expression
     */
    public static void main(String[] args) {
        String post_exp = "ABC/-AK/L-*";
        System.out.println("Prefix : " + convertPostFixToPrefix(post_exp));
    }
    static String convertPostFixToPrefix(String exp) {
        Stack<String> stack = new Stack<>();
        int length = exp.length();
        for (int i=0; i<length; i++) {
            if (isOperator(exp.charAt(i))) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(exp.charAt(i) + operand2 + operand1);
            } else {
                stack.push(exp.charAt(i) + "");
            }
        }
        StringBuilder result = new StringBuilder();
        for (String evalExp: stack) {
            result.append(evalExp);
        }
        return result.toString();
    }
    static boolean isOperator(char x)
    {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }
}
