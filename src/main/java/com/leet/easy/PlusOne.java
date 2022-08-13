package com.leet.easy;

public class PlusOne {

    // https://leetcode.com/problems/plus-one/

    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant
     * to least significant in left-to-right order. The large integer does not contain any leading 0's.
     *
     * Increment the large integer by one and return the resulting array of digits.
     */
    public static void main(String[] args) {
        int[] ints1 = plusOne(new int[]{1, 2, 3});
        for (int i: ints1) {
            System.out.print(i + ", "); // 1, 2, 4
        }

        System.out.println("----------");
        int[] ints2 = plusOne(new int[]{4,3,2,1});
        for (int i: ints2) {
            System.out.print(i + ", "); // 4,3,2,2
        }

        System.out.println("----------");
        int[] ints3 = plusOne(new int[]{9});
        for (int i: ints3) {
            System.out.print(i + ", "); // 1, 0
        }


    }

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + carry == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newArray[i+1] = digits[i];
            }
            return newArray;
        } else {
            return digits;
        }
    }


}
