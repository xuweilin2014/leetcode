package xu.linkedlist.problems;

/**
 * Problem 141 Linked List Cycles
 */
public class Problem141 extends SinglyLinkedListUtil {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }

        return false;
    }



}
