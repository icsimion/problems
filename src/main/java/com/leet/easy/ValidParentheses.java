package com.leet.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        isValid("()");             // Output: true
        isValid("()[]{}");         // Output: true
        isValid("(]");             // Output: Square: false
        isValid("([({})])");       // Output: true
        isValid("([({})]))");      // Output: Small: false
        isValid("([({})]");        // Output: Opened: false
        isValid("([)]");           // Output: Small: false
        isValid("{[]}");           // Output: true
    }

    private static boolean isValid(String s) { // fails for isValid("{[]}")
        int small = 0, square = 0, acco = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> small += 1;
                case ')' -> {
                    small -= 1;
                    if (small < 0 || square != 0 || acco != 0) {
                        System.out.println("Small: " + false);
                        return false;
                    }
                }
                case '[' -> square += 1;
                case ']' -> {
                    square -= 1;
                    if (square < 0 || small != 0 || acco != 0) {
                        System.out.println("Square: " + false);
                        return false;
                    }
                }
                case '{' -> acco += 1;
                case '}' -> {
                    acco -= 1;
                    if (acco < 0 || square != 0 || small != 0) {
                        System.out.println("Acco: " + false);
                        return false;
                    }
                }
                default -> {
                    System.out.println("Default: " + false);
                    return false;
                }
            }
        }
        if (small != 0 || square != 0 || acco != 0) {
            System.out.println("Opened: " + false);
            return false;
        }
        System.out.println(true);

        return true;
    }

    public static boolean isValidOptim(String s) {
        // Stack to store left symbols
        Stack<Character> leftSymbols = new Stack<>();
        // Loop for each character of the string
        for (char c : s.toCharArray()) {
            // If left symbol is encountered
            if (c == '(' || c == '{' || c == '[') {
                leftSymbols.push(c);
            }
            // If right symbol is encountered
            else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
                leftSymbols.pop();
            } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
                leftSymbols.pop();
            } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
                leftSymbols.pop();
            }
            // If none of the valid symbols is encountered
            else {
                return false;
            }
        }
        return leftSymbols.isEmpty();
    }


}
