package xu.linkedlist.problems;

/**
 *  Problem 61 Given a linked list, rotate the list to the right by k places, where k is non-negative.
 */

public class Problem61 extends SinglyLinkedListUtil {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        k = k % getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 0; i < k; i++) {
             ListNode beforeTail = getBeforeTail(dummy.next);
             ListNode tail = beforeTail.next;
             tail.next = dummy.next;
             beforeTail.next = null;
             dummy.next = tail;
        }
        return dummy.next;

    }

    public static ListNode rotateRightFinal(ListNode head,int k){
        if (head == null || head.next == null)
            return head;

        int len = getLength(head);
        k = k % len;

        if (k == 0)
            return head;

        int counter = 1;
        ListNode left = head;
        ListNode right = head;
        while (right.next != null){
            if(counter < len - k){
                counter++;
                left = left.next;
            }
            right = right.next;
        }
        ListNode node = left.next;
        right.next = head;
        left.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Problem61.addNode(head,2,0);
        Problem61.addNode(head,3,0);
        Problem61.addNode(head,4,0);
        Problem61.addNode(head,5,0);

        Problem61.printList(head);

        head = Problem61.rotateRightFinal(head,3);

        Problem61.printList(head);
    }

}
