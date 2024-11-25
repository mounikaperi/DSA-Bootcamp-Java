import java.util.*;

public class MaxProductSubArray {
  public static void main(String[] args) {
    int nums[] = {1,2,-3,0,-4,-5};
		int answer = maxProductSubArray(nums);
		answer = maxProductSubArrayBetter(nums);
		answer = maxProductSubArrayOptimal1(nums);
		System.out.print("The maximum product subarray is: "+answer);
  }
  private static int maxProductSubArray(int[] arr) {
    int result = Integer.MIN_VALUE;
    for (int i=0; i<arr.length; i++) {
      for (int j=i+1; j<arr.length; j++) {
        int prod = 1;
        for (int k=i; k<=j; k++) {
          prod = prod * arr[k];
        }
        result = Math.max(result, prod);
      }
    }
    return result;
  }
  private static int maxProductSubArrayBetter(int[] arr) {
    int result = arr[0];
    for (int i=0; i<arr.length-1; i++) {
      int prod = arr[i];
      for (int j=i+1; j<arr.length; j++) {
        result = Math.max(result, prod);
        prod = prod * arr[j];
      }
      result = Math.max(result, prod);
    }
    return result;
  }
  private static int maxProductSubArrayOptimal1(int[] arr) {
    int n = arr.length;
    int prefix = 1;
    int suffix = 1;
    int ans = Integer.MIN_VALUE;
    for (int i=0; i<n; i++) {
      if (prefix == 0) prefix = 1;
      if (suffix == 0) suffix = 1;
      prefix = prefix * arr[i];
      suffix = suffix * arr[n-i-1];
      ans = Math.max(ans, Math.max(prefix, suffix));
    }
    return ans;
  }
  // use suffix prefix approach
  private static int maxProductSubArrayOptimal2(int[] arr) {
    int prod1 = arr[0];
    int prod2 = arr[0];
    int result = arr[0];
    for (int i=1; i<arr.length; i++) {
      int temp = Math.max(arr[i], Math.max(prod1*arr[i], prod2*arr[i]));
      prod2 = Math.min(arr[i], Math.min(prod1*arr[i], prod2*arr[i]));
      prod1 = temp;
      result = Math.max(result, prod1);
    }
    return result;
  }
}
