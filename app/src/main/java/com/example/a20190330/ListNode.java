package com.example.a20190330;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }


    public static ListNode creatList(int[] list) {
        ListNode result = new ListNode(list[0]);
        ListNode head = result;
        for (int i = 1; i < list.length; i++) {
            head.next = new ListNode(list[i]);
            head = head.next;
        }
        return result;
    }

    public static String printList(ListNode head) {
        StringBuilder builder = new StringBuilder();
        builder.append(head.val);
//        System.out.print(head.val);
        while (head.next != null) {
            head = head.next;
            builder.append(" -> ").append(head.val);
//            System.out.print(" -> " + head.val);
        }
//        System.out.println();
        builder.append("\n");
        return builder.toString();
    }


}

