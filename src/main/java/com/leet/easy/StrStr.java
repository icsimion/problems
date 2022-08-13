package com.leet.easy;

public class StrStr {

    public static void main(String[] args) {
        int result1 = strStr("hello", "ll");
        System.out.println("Result1 = " + result1);

    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < (haystack.length() - needle.length()) + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

}
