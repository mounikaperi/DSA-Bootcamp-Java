package com.java.dsa.strings;

import java.util.ArrayList;
import java.util.HashMap;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 20;
        ArrayList<String> res = fizzBuzzNaive(n);
        for (String s : res) System.out.print(s + " ");
        System.out.println();

        res = fizzBuzzBetter(n);
        for (String s : res) System.out.print(s + " ");
        System.out.println();

        res = fizzBuzzOptimal(n);
        for (String s : res) System.out.print(s + " ");
        System.out.println();
    }
    static ArrayList<String> fizzBuzzNaive(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (i%3 ==0 && i%5==0)  result.add("FizzBuzz");
            else if (i%3 == 0) result.add("Fizz");
            else if (i%5 == 0) result.add("Buzz");
            else result.add(Integer.toString(i));
        }
        return result;
    }
    static ArrayList<String> fizzBuzzBetter(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            String s = "";
            if (i%3==0) s+="Fizz";
            if (i%5==0) s+= "Buzz";
            if (s.isEmpty()) s+=i;
            result.add(s);
        }
        return result;
    }
    static ArrayList<String> fizzBuzzOptimal(int n) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        int[] divisors = {3, 5};
        for (int i=1; i<=n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int d: divisors) {
                if (i%d == 0) sb.append(map.get(d));
            }
            if (sb.length() == 0) sb.append(i);
            result.add(sb.toString());
        }
        return result;
    }
}
