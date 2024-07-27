package com.java.dsa.bitmanipulation;
public class Conversions {
    public static void main(String[] args) {
        int number = 13;
        System.out.println("Convert " +number+ " to Binary: " + convertToBinary(number));
        String binaryNumber = "1101";
        System.out.println("Convert " +binaryNumber+ " to Decimal: " + convertToDecimal(binaryNumber));
    }
    static int convertToBinary(int number) {
        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            sb.append(number%2);
            number /= 2;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
    static int convertToDecimal(String binaryNumber) {
        int convertedBinaryNumber = Integer.parseInt(binaryNumber);
        int decimalNumber = 0; int multiplier = 1;
        while (convertedBinaryNumber > 0) {
            decimalNumber += (convertedBinaryNumber % 10) * multiplier;
            multiplier *= 2;
            convertedBinaryNumber /= 10;
        }
        return decimalNumber;
    }
}
