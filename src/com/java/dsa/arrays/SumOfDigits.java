package com.java.dsa.arrays;

class SumOfDigits {
  public static void main(String[] args) {
    int value = 98;
    System.out.println("The sum of digits till the number is single digit is: " + getSumNaive(value));
    System.out.println("The sum of digits till the number is single digit is: " + getSumOptimal(value));
  }
  private static int getSumNaive(int value) {
    int sum = 0; 
    // value should lower down to single digit that is till 9 and number should be greater than zero
    while (value > 0 && sum < 9) {
      if (value == 0) {
        value = sum; // this implies sum occured for first iteration value is more than single digit so we have to repeat the loop for the new value and go on till sum becomes < 9
        sum = 0;
      }
      sum += value % 10;
      value /=  10;
    }
    return sum;
  }
  private static int getSumOptimal(int n) {
    /**
     * Every number in the decimal system  can be expressed as sum of digits
     * multipled by powers of 10 
     * abcd => a*10^3 + b*10*2 + c*10^1 + d*10^0
     * abcd => a + b + c + d + (a*999 + b*99 + c*9)
     * abcd => a + b + c + d + 9 * (a*111 + b*11+ c*1)
     * This implies that any number can be expressed as the sum of its digits
     * plus multiple of 9. So if we take modulo with 9 on each side
     * (abcd % 9) = (a + b + c + d) % 9 +  9 * (a*111 + b*11+ c*1) % 9
     * (abcd % 9) = (a + b + c + d) % 9 + 0
     * This means that the remainder when abcd is divided by 9 is equal to the
     * remainder where the sum of digits is divided by 9
    */
    if (n == 0) return 0;
    if (n%9 == 0) return 9; // If result of modulo is 0 then digit is 9, 9%9= 0
    return (n%9);
  }
}
