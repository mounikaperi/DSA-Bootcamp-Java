package com.java.dsa.bitmanipulation;

public class CheckIfNumberIsEven {
    public static void main(String[] args) {
        int number = 23456;
        System.out.println("Is Number " + number + " Even? " + isNumberEven(number));
    }
    private static boolean isNumberEven(int number) {
        return (number & 1) == 1 ? false : true;
    }

}
