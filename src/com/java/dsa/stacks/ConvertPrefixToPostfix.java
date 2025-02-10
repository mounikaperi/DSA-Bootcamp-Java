package com.java.dsa.stacks;

import java.util.Stack;

public class ConvertPrefixToPostfix {
    /*
    - Read the prefix expression in reverse order (from right to left)
    - If the symbol is an operand, then push it into the stack
    - If the symbol is an operator, then pop two operands from the stack
        Create a string by concatenating the two operands and the operator after them.
        string = operand1 + operand2 + operator
        And push the resultant string back to Stack
    - Repeat the above steps until end of Prefix expression.
     */
    public static void main(String args[]) {
        String prefixExpression = "*-A/BC-/AKL";
        System.out.println("Postfix : " + prefixToPostfix(prefixExpression));
    }
    static String prefixToPostfix(String exp) {
        Stack<String> stack = new Stack<>();
        int length = exp.length();
        for (int i=length-1; i>=0; i--) {
            if (isOperator(exp.charAt(i))) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = operand1 + operand2 + exp.charAt(i);
                stack.push(result);
            } else {
                stack.push(exp.charAt(i) + "");
            }
        }
        return stack.peek();
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
