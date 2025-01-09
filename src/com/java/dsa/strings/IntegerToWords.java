package com.java.dsa.strings;

public class IntegerToWords {
    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(convertToWords(n));
        System.out.println(convertToWords1(n));
    }
    static String convertToWords(int n) {
        if (n == 0) return "Zero";
        String[] units = {
                "",        "One",       "Two",      "Three",
                "Four",    "Five",      "Six",      "Seven",
                "Eight",   "Nine",      "Ten",      "Eleven",
                "Twelve",  "Thirteen",  "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] tens = {
                "",     "",     "Twenty",  "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        String[] multiplier =
                {"", "Thousand", "Million", "Billion"};
        String res = "";
        int group = 0;

        while (n>0) {
            if (n % 1000 != 0) {
                int value = n % 1000;
                String temp = "";
                if (value >= 100) { // Handle 3 digit number
                    temp = units[value/100] + " Hundred ";
                    value %= 100;
                }
                if (value >= 20) { // Handle 2 digit number
                    temp += tens[value/10] + " ";
                    value %= 10;
                }
                if (value > 0) { // Handle unit number
                    temp += units[value] + " ";
                }
                // add the multiplier according to the group
                temp += multiplier[group] + " ";
                res = temp + res;
            }
            n /= 1000;
            group++;
        }
        return res.trim();
    }
    static String convertToWords1(int n) {
        // code here
        if (n==0) return "Zero";
        int[] values = {1000000000, 1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] words = {"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
        return convertToWordsRec(n, values, words);
    }
    static String convertToWordsRec(int n, int[] values, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<values.length; i++) {
            int value = values[i];
            String word = words[i];
            if (n >= value) {
                if (n >= 100) {
                    sb.append(convertToWordsRec(n/value, values, words));
                    sb.append(" ");
                }
                sb.append(word);
                if (n % value > 0) {
                    sb.append(" ");
                    sb.append(convertToWordsRec(n%value, values, words));
                }
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
