package com.java.dsa.bitmanipulation;
public class Conversions {
    public static void main(String[] args) {
        int number1 = 12; int number2 = 25;
        String binaryNumber = "1100";
        System.out.println("Convert " +number1+ " to Binary: " + convertToBinary(number1));
        System.out.println("Convert " +binaryNumber+ " to Decimal: " + convertToDecimal(binaryNumber));
        System.out.println("Convert " +number1+ " to 1's compliment: " + convertTo1sCompliment(number1));
        System.out.println("Convert " +number1+ " to 2's compliment: " + convertTo2sCompliment(number1));
        System.out.println("Bitwise AND for number1: " +number1+ " and number2: " +number2+ " is " +bitwiseAnd(number1, number2));
        System.out.println("Bitwise OR for number1: " +number1+ " and number2: " +number2+ " is " +bitwiseOr(number1, number2));
        System.out.println("Bitwise XoR for number1: " +number1+ " and number2: " +number2+ " is " +bitwiseXor(number1, number2));
        System.out.println("LeftShift for number1: " +number1+ " is " +leftShift(number1));
        System.out.println("RightShift for number1: " +number1+ " is " +rightShift(number1));
        System.out.println("Not for number1: " +number1+ " is " +not(number1));
    }
    static String convertToBinary(int number) {
        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            sb.append(number%2);
            number /= 2;
        }
        return sb.reverse().toString();
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
    static String convertTo1sCompliment(int number) {
        String binaryNumber = convertToBinary(number);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<binaryNumber.length(); i++) {
            sb.append(binaryNumber.charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    static String convertTo2sCompliment(int number) {
        /**
         * Step 1:  Start from the Least Significant Bit and traverse left until you find a 1.  Until you find 1, the bits stay the same
         *
         * Step 2: Once you have found 1, let the 1 as it is, and now
         *
         * Step 3: Flip all the bits left into the 1.
         */
        String onesComplement = convertTo1sCompliment(number);
        boolean carry = true;
        StringBuilder result = new StringBuilder();
        for (int i=onesComplement.length()-1; i>=0; i--) {
            if (onesComplement.charAt(i) == '1' && carry) {
                result.insert(0, '0');
            } else if (onesComplement.charAt(i) == '0' && carry) {
                result.insert(0, '1');
                carry = false;
            } else {
                result.insert(0, onesComplement.charAt(i));
            }
        }
        if (carry) {
            result.insert(0, '1');
        }
        return result.toString();
    }
    static int bitwiseAnd(int number1, int number2) {
        return number1 & number2;
    }
    static int bitwiseOr(int number1, int number2) {
        return number1 | number2;
    }
    static int bitwiseXor(int number1, int number2) {
        // If number of 1s are odd -> 1, If number of 1s are even -> 0
        return number1 ^ number2;
    }
    static int leftShift(int number) {
        // left shift by k places means num * Math(2, k)
        return number << 5;
    }
    static int rightShift(int number) {
        // right shift by k places -> num / Math.pow(2, k)
        return number >> 1;
    }
    static int not(int number) {
        // flip bits- check if negative - if it is negative do 2s complement else stop
        return ~number;
    }
}
