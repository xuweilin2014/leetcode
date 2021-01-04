package xu.linkedlist.problems;

/**
 * 19. Remove Nth Node From End of List
 */
public class Problem19 extends SinglyLinkedListUtil {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }

        long listLength = 1;
        ListNode node = head.next;
        while (node != null){
            listLength++;
            node = node.next;
        }

        long index = listLength - n + 1;
        long counter = 1;
        ListNode dummy = new ListNode(0);
        ListNode prev = null;
        dummy.next = head;
        prev = dummy;
        node = head;

        while (counter != index){
            prev = node;
            node = node.next;
            counter++;
        }

        prev.next = node.next;

        return dummy.next;
    }

}
