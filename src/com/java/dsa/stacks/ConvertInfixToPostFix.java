package com.java.dsa.stacks;

import java.util.Stack;

public class ConvertInfixToPostFix {
    // To convert infix expression to postfix expression, use the stack data structure
    // Scan the infix from left to right
    // Whenever we get an operand, add it to the postfix expression and if we get an operator or parentheses
    // add it to the stack by maintaining their precedence.


    // Scan the infix expression from left to right
    // If the scanned character is an operand, put it in the postfix expression
    // Otherwise, do the following
    // If the precedence of the current scanned operator is higher than the precedence of the operator on top
    // of the stack, or if the stack is empty, or if the stack contains a '(' then push the current operator
    // onto the stack.
    // Else, pop all the operators from the stack that have precedence higher than or equal to that of current
    // operator. After that push the current operator onto the stack

    // If the scanned character is '(' push it into the stack
    // If the scanned character is ')' pop the stack output it until a '(' is encountered and discard both parentheses.
    // Repeat steps until the infix expression is scanned.
    // Once the scanning is over, pop the stack and add the operators in the postfix expression until it is not empty
    // Finally, print the postfix expression

    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPostfix(exp));
    }
    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // if the scanned character is an ')' pop and add to the output string from the stack until '(' is encountered
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else { // If an operator is scanned
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        // pop all operators from stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "InvalidExpression";
            result.append(stack.pop());
        }
        return result.toString();
    }
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
