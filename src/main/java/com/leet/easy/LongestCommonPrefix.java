package com.leet.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        longestCommonPrefix(new String[] {"","flow","flight"});             // Output:
        longestCommonPrefix(new String[] {"flower","flow","flight"});       // Output: fl
        longestCommonPrefix(new String[] {"flow","flow","flow"});           // Output: flow
        longestCommonPrefix(new String[] {"dog","racecar","car"});          // Output:
    }

    private static String longestCommonPrefix(String[] strs){
        String first = strs[0];
        boolean matching = true;
        int idx = 0;
        if (first.length() < 1) {
            System.out.println("Output: ");
            return "";
        }
        do {
            String prefix = first.substring(0, idx + 1);
            for(String s : strs) {
                if (!s.startsWith(prefix)) {
                    matching = false;
                    break;
                }
            }
            if (matching) {
                idx++;
            }
        } while (matching && idx < first.length());

        System.out.println("Output: " + first.substring(0, idx));
        return first.substring(0, idx);
    }

    public static String longestCommonPrefixOptim(String[] strs) {
        // Longest common prefix string
        StringBuilder longestCommonPrefix = new StringBuilder();
        // Base condition
        if (strs == null || strs.length == 0) {
            return longestCommonPrefix.toString();
        }
        // Find the minimum length string from the array
        int minimumLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minimumLength = Math.min(minimumLength, strs[i].length());
        }
        // Loop for the minimum length
        for (int i = 0; i < minimumLength; i++) {
            // Get the current character from first string
            char current = strs[0].charAt(i);
            // Check if this character is found in all other strings or not
            for (String str : strs) {
                if (str.charAt(i) != current) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(current);
        }
        return longestCommonPrefix.toString();
    }

}
