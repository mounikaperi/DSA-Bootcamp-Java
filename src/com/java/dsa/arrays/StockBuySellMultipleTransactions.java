import java.util.*;

public class StockBuySellMultipleTransactions {
    public static void main(String[] args) {
      // https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/stock-buy-and-sell2615
      int[] prices = {100, 180, 260, 310, 40, 535, 695};
      int maximumProfit = maximumProfit(prices);
      System.out.println("The maximumProfit earned by selling and buying stocks is: " + maximumProfit);
    }
    private static int maximumProfit(int[] prices) {
      int sum = 0;
      for (int i=1; i<prices.length; i++) {
        if (prices[i] > prices[i-1])
          sum += (prices[i] - prices[i-1]);
      }
      return sum;
    }
}
