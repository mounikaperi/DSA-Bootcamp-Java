package com.java.dsa.sorting;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {6, 0, 3, 5, 3};
        System.out.println(hIndex(citations));
        System.out.println(hIndexOptimal(citations));
    }
    static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int index =0;
        while (index <n && citations[n-1-index] > index) {
            index++;
        }
        return index;
    }
    static int hIndexOptimal(int[] citations) {
        /*
            The idea is similar to Counting Sort and maintain an array of size n + 1,
            say freq[] to count the frequency of citations of each paper.

            So, freq[i] will store the number of papers having i citations.
            To handle the case when number of citations > n, we can simply replace them
            with n. This is because the value of H-Index can be at most n as we have total
            n papers only.

            After counting the frequency of citations, start from last index n and for
            each index i, keep track of the count of papers having at least i citations.
            If at any index i, the count of papers having at least i citations becomes >= i,
            then we can simply return i as the H-Index. We started from the last index n
            because we want to maximize the H-Index.
         */

        int n = citations.length;
        int[] freq = new int[n+1];
        for (int i=0; i<n; i++) {
            if (citations[i] >= n) freq[n] += 1;
            else freq[citations[i]] +=1;
        }
        int index = n;
        int s = freq[n];
        while (s < index) {
            index--;
            s += freq[index];
        }
        return index;
    }
}
