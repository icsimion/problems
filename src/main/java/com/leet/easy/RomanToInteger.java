package com.leet.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        romanToInt("III");          // Input: III; Output: 3
        romanToInt("LVIII");        // Input: LVIII; Output: 58
        romanToInt("MCMXCIV");      // Input: MCMXCIV; Output: 1994
    }

    private static int romanToInt(String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int l = s.length();
        int sum = map.get(s.charAt(l - 1));
        for (int i = l - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                sum += map.get(s.charAt(i));
            } else {
                sum -= map.get(s.charAt(i));
            }
        }
        System.out.println("Input: " + s + "; Output: " + sum);
        return sum;
    }
}
