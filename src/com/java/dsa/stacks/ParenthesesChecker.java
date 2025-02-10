package com.java.dsa.stacks;

import java.util.Stack;

public class ParenthesesChecker {
    public static void main(String[] args) {
        System.out.println(isParenthesesBalanced("[()()]{}"));
    }
    static boolean isParenthesesBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && (
                        ch == '}' && stack.peek() == '{'
                     || ch == ')' && stack.peek() == '('
                     || ch == ']' && stack.peek() == '['
                )) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
