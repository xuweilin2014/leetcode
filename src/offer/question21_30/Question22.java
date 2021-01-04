package offer.question21_30;

import xu.linkedlist.problems.ListNode;

import xu.linkedlist.problems.SinglyLinkedListUtil;

public class Question22{

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(FindKthToTail(head, 6));
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        int counter = 1;

        while (fast.next != null && counter <= k - 1){
            fast = fast.next;
            counter++;
        }

        if (counter < k)
            return null;

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
