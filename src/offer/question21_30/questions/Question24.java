package offer.question21_30.questions;

import xu.linkedlist.problems.ListNode;
import xu.linkedlist.problems.SinglyLinkedListUtil;

public class Question24 {

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{1,2});
        head = new Question24().ReverseList(head);
        SinglyLinkedListUtil.printList(head);
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        ListNode prev = null;
        while (p != null){
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }

        return prev;
    }

}
