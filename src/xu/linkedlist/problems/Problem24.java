package xu.linkedlist.problems;

/**
 * 24.Swap Nodes in Pair
 */
public class Problem24{

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev;
        ListNode slow;
        ListNode fast = dummy;
        while (fast.next != null && fast.next.next != null){
            prev = fast;
            slow = prev.next;
            fast = slow.next;

            swap0(prev, fast, slow);
            ListNode tmp = fast;
            fast = slow;
            slow = tmp;
        }

        return dummy.next;
    }

    private void swap0(ListNode prev, ListNode fast, ListNode slow){
        prev.next = fast;
        slow.next = fast.next;
        fast.next = slow;
    }


    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem24().swapPairs(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2});
        SinglyLinkedListUtil.printList(new Problem24().swapPairs(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        SinglyLinkedListUtil.printList(new Problem24().swapPairs(node));
    }
}
