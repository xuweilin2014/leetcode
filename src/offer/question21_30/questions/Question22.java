package offer.question21_30.questions;

import xu.linkedlist.problems.ListNode;

import xu.linkedlist.problems.SinglyLinkedListUtil;

import java.util.List;

public class Question22{

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(new Question22().getKthFromEnd(head, 6));
    }

}
