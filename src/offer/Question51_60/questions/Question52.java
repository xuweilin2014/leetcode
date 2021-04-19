package offer.Question51_60.questions;

import xu.linkedlist.problems.ListNode;

public class Question52 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2){
            if (p1 == null){
                p1 = pHead2;
            }else {
                p1 = p1.next;
            }
            if (p2 == null){
                p2 = pHead1;
            }else {
                p2 = p2.next;
            }
        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(9);
        ListNode b5 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        a3.next = b4;

        System.out.println(new Question52().FindFirstCommonNode(a1, b1));
    }

}
