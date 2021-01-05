package xu.linkedlist.problems;

/**
 * 19. Remove Nth Node From End of List
 */
public class Problem19 extends SinglyLinkedListUtil {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode prev = slow;
        int counter = 1;
        while (counter <= n){
            fast = fast.next;
            counter++;
        }

        while (fast != null){
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = slow.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode head = new Problem19().removeNthFromEnd(node, 2);
        SinglyLinkedListUtil.printList(head);
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        head = new Problem19().removeNthFromEnd(node, 5);
        SinglyLinkedListUtil.printList(head);
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1});
        head = new Problem19().removeNthFromEnd(node, 1);
        SinglyLinkedListUtil.printList(head);
    }

}
