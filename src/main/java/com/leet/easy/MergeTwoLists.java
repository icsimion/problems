package com.leet.easy;

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode node13 = new ListNode(4);
        ListNode node12 = new ListNode(2, node13);
        ListNode node11 = new ListNode(1, node12);
        ListNode node23 = new ListNode(4);
        ListNode node22 = new ListNode(3, node23);
        ListNode node21 = new ListNode(1, node22);
        ListNode result1 = mergeTwoLists(node11, node21);
        System.out.println(result1);    // Output: true
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // https://redquark.org/leetcode/0021-merge-two-sorted-lists/
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // check not empty
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        //init first value
        ListNode result;
        ListNode cursor;
        if (list1.val <= list2.val) {
            result = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            result = new ListNode(list2.val);
            list2 = list2.next;
        }
        cursor = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cursor.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cursor.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cursor = cursor.next;
        }

        // if elements remain
        while (list1 != null) {
            cursor.next = new ListNode(list1.val);
            list1 = list1.next;
            cursor = cursor.next;
        }
        while (list2 != null) {
            cursor.next = new ListNode(list2.val);
            list2 = list2.next;
            cursor = cursor.next;
        }
        return result;
    }
}
