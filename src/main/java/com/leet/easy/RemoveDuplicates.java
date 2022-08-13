package com.leet.easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {

    public static void main(String[] args) {
        int result0 = removeDuplicates(new int[]{1, 1});
        System.out.println("Index = " + result0); // should be 1;
        int result1 = removeDuplicates(new int[]{1, 2});
        System.out.println("Index = " + result1);
        int result2 = removeDuplicates(new int[]{1, 1, 2});
        System.out.println("Index = " + result2);
//        1, 2, 1, switch: 1 - 2
//        Index = 2
        int result3 = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println("Index = " + result3);
//        0, 1, 0, 1, 1, 2, 2, 3, 3, 4, switch: 1 - 2
//        0, 1, 2, 1, 1, 0, 2, 3, 3, 4, switch: 2 - 5
//        0, 1, 2, 3, 1, 0, 2, 1, 3, 4, switch: 3 - 7
//        0, 1, 2, 3, 4, 0, 2, 1, 3, 1, switch: 4 - 9
//        0, 1, 2, 3, 4, 0, 2, 3, 1, 1, switch: 7 - 8
//        Index = 5
    }

    // my implementation. does not pass tests for result0
    public static int removeDuplicates0(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int max = 0, k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j] && nums[j] > max) {
                        int temp = nums[i + 1];
                        nums[i + 1] = nums[j];
                        nums[j] = temp;
                        max = nums[i + 1];
                        k = i + 1;
                        for (int idx = 0; idx < nums.length; idx++) {
                            System.out.print(nums[idx] + ", ");
                        }
                        System.out.println("switch: " + (i + 1) + " - " + j);
                        break;
                    }
                }
            }
        }
        if (max == 0) {
            return nums.length;
        }
        return k + 1;
    }


//    https://redquark.org/leetcode/0026-remove-duplicates-from-sorted-array/
    /**
     * Approach
     * One important thing in the question is that the array is sorted. This means that all the duplicate elements will be adjacent to each other. For e.g., in the array [1,2,2,
     * 3,4,4,4,5,5,6,7], we see all the duplicate elements are adjacent to each other.
     *
     * We can use this property of the sorted array containing duplicates to solve this question using the following steps —
     *
     * Check if the current and the next element are equal.
     * If they are, we will skip the next element and will continue the procedure as long as we encounter the duplicates.
     * If the elements are not duplicate, we will place the next (different) element next to the current element.
     * Time Complexity
     * We are scanning the array once, hence the time complexity will be O(n).
     *
     * Space Complexity
     * Since we are forbidden to use the external data structure (and we are not using it 😛), the space complexity will be O(1).
     */
    public static int removeDuplicates(int[] nums) {
        // Length of the updated array
        int count = 0;
        // Loop for all the elements in the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is equal to the next element, we skip
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            // We will update the array in place
            nums[count] = nums[i];
            count++;
        }
        for (int idx = 0; idx < nums.length; idx++) {
            System.out.print(nums[idx] + ", ");
        }

        return count;
    }

}
