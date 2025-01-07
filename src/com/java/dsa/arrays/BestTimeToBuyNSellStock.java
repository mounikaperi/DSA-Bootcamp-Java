package com.java.dsa.arrays;
public class BestTimeToBuyNSellStock {
    public static void main(String[] args) {
      int[] prices = {7,1,5,3,6,4};
      int maxProfit = findMaxProfit(prices);
      System.out.println("Max profit is: " + maxProfit);
    }
    private static int findMaxProfit(int[] prices) {
      int maxProfit = 0;
      int minStock = prices[0];
      for (int i=1; i<prices.length; i++) {
        minStock = Math.min(minStock, prices[i]);
        maxProfit = Math.max(maxProfit, prices[i] - minStock);
      }
      return maxProfit;
    }
}