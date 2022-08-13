package com.leet.easy;

public class RemoveDuplicates {

    public static void main(String[] args) {
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

    public static int removeDuplicates(int[] nums) {
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
}
