package xu.linkedlist;

/**
 * 876. Middle of the Linked List
 */

public class Problem876 extends SinglyLinkedListUtil{
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        if (head.next.next == null)
            return head.next;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
