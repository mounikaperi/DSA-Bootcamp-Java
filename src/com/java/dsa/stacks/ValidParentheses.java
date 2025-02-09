package com.java.dsa.stacks;

import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses {
    // https://leetcode.com/problems/valid-parentheses/description/
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch: s.toCharArray()) {
            if (ch == '{' || ch ==  '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char poppedch = stack.pop();
                if ((ch == ')' && poppedch == '(')
                    || (ch == '}' && poppedch == '{')
                    || (ch == ']' && poppedch == '[')
                ) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
