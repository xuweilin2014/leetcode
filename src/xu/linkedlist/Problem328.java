package xu.linkedlist;

/**
 * 328. Odd Even Linked List
 */

public class Problem328 extends SinglyLinkedListUtil {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode podd = head;
        ListNode peven = head.next;
        ListNode node = head.next.next;
        ListNode next = null;
        int index = 3;

        while (node != null){
            if (index % 2 == 0){
                peven = node;
                node = node.next;
            }else{
                next = node.next;
                peven.next = node.next;
                node.next = podd.next;
                podd.next = node;
                podd = node;
                node = next;
            }
            index++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        Problem328.addNode(head, 1, 0);
        Problem328.addNode(head, 3, 0);
        Problem328.addNode(head, 5, 0);
        Problem328.addNode(head, 6, 0);
        Problem328.addNode(head, 4, 0);
        Problem328.addNode(head, 7, 0);

        Problem328.printList(head);

        head = Problem328.oddEvenList(head);

        Problem328.printList(head);
    }

}
