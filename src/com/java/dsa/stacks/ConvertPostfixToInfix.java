package com.java.dsa.stacks;

import java.util.Stack;

public class ConvertPostfixToInfix {
    public static void main(String[] args) {
        String exp = "ab*c+";
        System.out.println(postfixToInfix(exp));
    }
    static String postfixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i=0; i<exp.length(); i++) {
            if (Character.isLetter(exp.charAt(i))) {
                stack.push(exp.charAt(i) + "");
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push("(" + operand2 + exp.charAt(i) + operand1 + ")");
            }
        }
        return stack.peek();
    }
}
