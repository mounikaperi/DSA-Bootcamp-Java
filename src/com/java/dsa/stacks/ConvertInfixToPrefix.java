package com.java.dsa.stacks;

import java.util.Stack;

public class ConvertInfixToPrefix {
    /*
        Approach:
            https://www.geeksforgeeks.org/convert-infix-prefix-notation/
            The idea is to first reverse the given infix expression while swapping '(' and ')' viceversa
            Convert the modified expression to postfix notation using stack based approach that follows
            operator precedence and associative rules and finally reverse the obtained postfix expression
            to get the prefix notation.
        Algorithm:
        - Reverse infix expression. braces will get reversed
        - Convert the reversed infix expression to postfix expression
            - Initialize an empty stack to store operators and an empty string for the postfix expression
            - Scan the infix expression from left to right.
            - If the character is an operand, append it to the postfix expression.
            - If the character is ‘(‘, push it onto the stack.
            - If the character is ‘)’, pop from the stack and append to the postfix expression until ‘(‘ is found, then pop ‘(‘ without appending.
            - If the character is an operator, pop and append operators from the stack until the stack is empty or a lower precedence operator is found, then push the current operator onto the stack.
            - After scanning the expression, pop and append all remaining operators from the stack to the postfix expression.
         - Reverse the postfix expression and return it.
     */
    public static void main(String[] args) {
        String s = "(a-b/c)*(a/k-l)";
        System.out.println(convertInfixToPrefix(s));
    }
    static String convertInfixToPrefix(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        infix = sb.reverse().toString();
        char[] reversedInfixChars = infix.toCharArray();
        for (int i=0; i<reversedInfixChars.length; i++) {
            if (reversedInfixChars[i] == '(') {
                reversedInfixChars[i] = ')';
            } else if (reversedInfixChars[i] == ')') {
                reversedInfixChars[i] = '(';
            }
        }
        String convertedPostfixExpression = convertInfixToPostfix(new String(reversedInfixChars));
        return new StringBuilder(convertedPostfixExpression).reverse().toString();
    }
    static String convertInfixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int length = s.length();
        for (int i=0; i<length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push('(');
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && operatorPrecedence(ch) <= operatorPrecedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
    static int operatorPrecedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return -1;
    }
}
