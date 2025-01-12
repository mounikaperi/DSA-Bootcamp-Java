package com.java.dsa.sorting;

import java.util.Arrays;

public class MinSumOfTwoNumbersInArray {
    static String addString(StringBuilder s1, StringBuilder s2) {
        int i = s1.length()-1;
        int j = s2.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i>=0 || j>=0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += (s1.charAt(i) - '0');
            if (j >= 0) sum += (s2.charAt(j) - '0');
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        // remove leading zeros which are currently at the back  due to reversed string
        while (res.length() > 0 && res.charAt(res.length()-1) == '0')
            res.deleteCharAt(res.length()-1);
        res.reverse();
        return res.toString();
    }
    static String minSum(int[] arr) {
        Arrays.sort(arr);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if (i%2==0) s1.append(arr[i]);
            else s2.append(arr[i]);
        }
        return addString(s1, s2);
    }
    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3, 0};

        System.out.println(minSum(arr));
    }
}
