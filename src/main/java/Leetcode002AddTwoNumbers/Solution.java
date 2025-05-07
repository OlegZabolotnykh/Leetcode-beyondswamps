package main.java.Leetcode002AddTwoNumbers;

public class Solution {
    public static void main(String[] args) {
        int[] l1ints = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] l2ints = new int[]{9, 9, 9, 9};

        ListNode l1 = new ListNode(l1ints[0]);
        ListNode l2 = new ListNode(l2ints[0]);
        ListNode currl1 = l1;
        ListNode currl2 = l2;
        for (int i = 1; i < l1ints.length; i++) {
            currl1.next = new ListNode(l1ints[i]);
            currl1 = currl1.next;
        }

        for (int i = 1; i < l2ints.length; i++) {
            currl2.next = new ListNode(l2ints[i]);
            currl2 = currl2.next;
        }

        ListNode l3 = addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.print(l3.val + " --> ");
            l3 = l3.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
        ListNode l3curr = l3;
        int shifted = (l1.val + l2.val) / 10;
        while (l1.next != null && l2.next != null) {
            l3curr.next = new ListNode((l1.next.val + l2.next.val + shifted) % 10);
            shifted = (l1.next.val + l2.next.val + shifted) / 10;
            l1 = l1.next;
            l2 = l2.next;
            l3curr = l3curr.next;
        }
        while (l1.next != null) {
            l3curr.next = new ListNode((l1.next.val + shifted) % 10);
            shifted = (l1.next.val + shifted) / 10;
            l3curr = l3curr.next;
            l1 = l1.next;
        }

        while (l2.next != null) {
            l3curr.next = new ListNode((l2.next.val + shifted) % 10);
            shifted = (l2.next.val + shifted) / 10;
            l3curr = l3curr.next;
            l2 = l2.next;
        }

        if (shifted != 0) {
            l3curr.next = new ListNode(shifted);
        }

        return l3;
    }


//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
//        ListNode l3curr = l3;
//        int shifted = (l1.val + l2.val) / 10;
//        l1 = l1.next;
//        l2 = l2.next;
//        while (l1 != null && l2 != null) {
//            l3curr.next = new ListNode((l1.val + l2.val + shifted) % 10);
//            shifted = (l1.val + l2.val + shifted) / 10;
//            l1 = l1.next;
//            l2 = l2.next;
//            l3curr = l3curr.next;
//        }
//        while (l1 != null) {
//            l3curr.next = new ListNode(l1.val + shifted);
//            l3curr = l3curr.next;
//            l1 = l1.next;
//            shifted = 0;
//        }
//
//        while (l2 != null) {
//            l3curr.next = new ListNode(l2.val + shifted);
//            l3curr = l3curr.next;
//            l2 = l2.next;
//            shifted = 0;
//        }
//
//        return l3;
//    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(Integer val) {
            this.val = val;
        }

        ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
