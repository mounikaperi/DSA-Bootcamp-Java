package com.java.dsa.recursion;

public class DecimalToBinaryNumberConversion {
    public static void main(String args[]) {
        int decimal_number = 10;
        System.out.println(find(decimal_number));
        decimalToBinary(1048576); // o(logn)
        System.out.print(binaryNumber);
    }
    static int find(int decimalNumber) {
        if (decimalNumber == 0) {
            return 0;
        } else {
            return (decimalNumber % 2 + 10 * find(decimalNumber / 2));
        }
    }

    /*
    The above approach works fine unless you want to convert a number greater than 1023 in decimal to binary.
    The binary of 1024 is 10000000000 which goes out of range for int.
    Even with long long unsigned as return type the highest you can go is 1048575 which is way less than the range of int.
    As easier but effective approach would be to store the individual digits of the binary number in vector of pool
     */
    static String binaryNumber = "";
    static void decimalToBinary(int n) {
        if (n <= 1) {
            binaryNumber += (char) (n + '0');
        } else {
            decimalToBinary((int)(n/2));
            if (n % 2 != 0) {
                binaryNumber += '1';
            } else {
                binaryNumber += '0';
            }
        }
    }
}
