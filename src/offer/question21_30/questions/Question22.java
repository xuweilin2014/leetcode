package offer.question21_30.questions;

import xu.linkedlist.problems.ListNode;

import xu.linkedlist.problems.SinglyLinkedListUtil;

import java.util.List;

public class Question22{

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0)
            return null;

        ListNode fast = head;
        for (int i = 0; i < k - 1 && fast != null; i++) {
            fast = fast.next;
        }

        if (fast == null)
            return null;

        ListNode slow = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(new Question22().getKthFromEnd(head, 6));

        head = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(new Question22().getKthFromEnd(head, 0));
    }

}
