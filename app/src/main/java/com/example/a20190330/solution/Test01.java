package com.example.a20190330.solution;


import com.example.a20190330.ListNode;

public class Test01 {


//    public static void main(String[] args) {
//
//        int arrA[] = {1, 4, 3};
//        int arrB[] = {5, 5, 4};
//        ListNode headA = new ListNode(arrA[0]);
//        ListNode headB = new ListNode(arrB[0]);
//        ListNode p = headA;
//        for (int i = 1; i < arrA.length; i++) {
//            p.next = new ListNode(arrA[i]);
//            p = p.next;
//        }
//        p = headB;
//        for (int i = 1; i < arrA.length; i++) {
//            p.next = new ListNode(arrA[i]);
//            p = p.next;
//        }
//        p = headA;
//        while (p != null) {
//            System.out.print(p.val + " ");
//            p = p.next;
//        }
//        System.out.print("\n");
//        p = headB;
//        while (p != null) {
//            System.out.print(p.val + " ");
//            p = p.next;
//        }
//        System.out.print("\n");
//
//    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) {
//            val = x;
//        }
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = new ListNode(0);
        p = listNode;
        int sum = 0;

        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            sum = sum / 10;
            p = p.next;
        }
        return listNode.next;

    }

}
