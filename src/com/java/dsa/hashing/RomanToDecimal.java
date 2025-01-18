package com.java.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {
    public static void main(String[] args) {
        String s = "IX";
        System.out.println(romanToDecimalNaive(s));
        System.out.println(romanToDecimal(s));
    }
    public static int romanToDecimal(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i=0; i<s.length(); i++) {
            // if the value at currentIndex is < value at next index decrement and add to result
            if (i+1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                result += (map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
                i++;
            } else {
                result += map.get(s.charAt(i));
            }
        }

        return result;
    }
    public static int romanToDecimalNaive(String s) {
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            int s1 = value(s.charAt(i));
            if (i+1 < s.length()) {
                int s2 = value(s.charAt(i+1));
                if (s1 >= s2) res += s1;
                else {
                    res += (s2-s1);
                    i++;
                }
            } else {
                res += s1;
            }
        }
        return res;
    }
    static int value(char r) {
        switch (r) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}
