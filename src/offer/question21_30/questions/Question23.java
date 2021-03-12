package offer.question21_30.questions;

import xu.linkedlist.problems.ListNode;
import xu.linkedlist.problems.SinglyLinkedListUtil;

import java.util.List;

public class Question23 {

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{1,2,3,4,5,6,7});
        ListNode node7 = SinglyLinkedListUtil.getNode(head, 5);
        ListNode node3 = SinglyLinkedListUtil.getNode(head, 1);
        node7.next = node3;
        System.out.println(EntryNodeOfLoop(head));
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null)
            return null;

        ListNode fast = pHead;
        ListNode slow = pHead;

        do {
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != null && fast.next != null && fast != slow);

        if (fast == null || fast.next == null)
            return null;

        slow = pHead;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
