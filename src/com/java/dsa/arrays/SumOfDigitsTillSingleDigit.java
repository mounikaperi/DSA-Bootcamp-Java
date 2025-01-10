package com.java.dsa.arrays;

public class SumOfDigitsTillSingleDigit {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(singleDigit(n));
        n = 1234;
        System.out.println(singleDigitExpected(n));
    }
    static int singleDigit(int n) {
        int sum = 0;
        while (n>0 || sum > 9) {
            if (n == 0) {
                // if n becomes 0, reset it to sum and start a new iteration
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n = n/10;
        }
        return sum;
    }
    static int singleDigitExpected(int n) {
        /*
            We know that every number in the decimal system can be expressed as a sum of its digits multiplied by powers of 10. For example, a number represented as abcd can be written as follows:

            abcd = a*10^3 + b*10^2 + c*10^1 + d*10^0

            We can separate the digits and rewrite this as:
            abcd = a + b + c + d + (a*999 + b*99 + c*9)
            abcd = a + b + c + d + 9*(a*111 + b*11 + c)

            This implies that any number can be expressed as the sum of its digits plus a multiple of 9.
            So, if we take modulo with 9 on each side,
            abcd % 9 = (a + b + c + d) % 9 + 0

            This means that the remainder when abcd is divided by 9 is equal to the remainder where the sum of its digits (a + b + c + d) is divided by 9.

            If the sum of the digits itself consists of more than one digit, we can further express this sum as the sum
            of its digits plus a multiple of 9. Consequently, taking modulo 9 will eliminate the multiple of 9, until
            the sum of digits become single digit number.

            As a result, the sum of the digits of any number, will equal its modulo 9.
            If the result of the modulo operation is zero, it indicates that the single-digit result is 9.
         */
        if (n ==0) return 0;
        if (n%9 == 0) return 9;
        return n%9;
    }
}
