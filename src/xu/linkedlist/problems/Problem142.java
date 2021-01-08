package xu.linkedlist.problems;

/**
 * Problem 142 Linked List Cycle II Important
 */
public class Problem142{

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        ListNode cur = head;
        while (cur != fast){
            cur = cur.next;
            fast = fast.next;
        }

        return cur;
    }

}
