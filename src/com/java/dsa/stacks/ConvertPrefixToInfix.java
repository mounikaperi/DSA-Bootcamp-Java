package com.java.dsa.stacks;

import java.util.Arrays;
import java.util.Stack;

public class ConvertPrefixToInfix {
    /*
        Algorithm:
        - Read the prefix expression in reverse order
        - If the symbol is an operand, then push it into the stack
        - If the symbol is an operator, then pop two operands from the stack
        - Create a string by concatenating two operands and the operator between them.
          string = (operand1 + operator + operand2)
          and push the resultant string back to the stack
        - Repeat the above steps until the end of the prefix expression
        - At the end stack will have only one string i.e resultant string
     */
    public static void main(String[] args) {
        String expression = "*-A/BC-/AKL";
        System.out.println("Infix : " + prefixToInfix(expression));
    }
    static String prefixToInfix(String str) {
        Stack<String> stack = new Stack<>();
        int length = str.length();
        for (int i=length-1; i>=0; i--) {
            char ch = str.charAt(i);
            if (Arrays.asList('+','-', '*', '/', '^', '%').contains(ch)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = "(" + operand1 + ch + operand2 + ")";
                stack.push(result);
            } else {
                stack.push(ch + "");
            }
        }
        return stack.pop();
    }
}
