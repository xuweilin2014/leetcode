package offer.Question51_60.questions;

import xu.linkedlist.problems.ListNode;

public class Question52 {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(4);
        ListNode b5 = new ListNode(5);
        b1.next = b2;
//        b2.next = b3;

        System.out.println(new Question52().getIntersectionNode(a1, b1));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

}