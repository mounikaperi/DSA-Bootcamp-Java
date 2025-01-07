package com.java.dsa.arrays;

import java.util.*;

public class ArrayLeaders {
    public static void main(String[] args) {
      // https://www.naukri.com/code360/problems/superior-elements_6783446?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
      int[] a = {5, 4, 3};
      List<Integer> result = superiorElements(a);
      for (int value: result) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
    private static List< Integer > superiorElements(int []a) {
        List<Integer> ans = new ArrayList<>();
        int max = a[a.length-1];
        ans.add(a[a.length-1]);
        for (int i=a.length-2; i>=0; i--) {
            if (a[i] > max) {
                max = a[i];
                ans.add(a[i]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}