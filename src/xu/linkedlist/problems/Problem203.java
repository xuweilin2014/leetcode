package xu.linkedlist.problems;

/**
 * 203. Remove Linked List Elements
 */

public class Problem203 extends SinglyLinkedListUtil {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;

        while (cur != null){
            if (cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        SinglyLinkedListUtil.addNode(head, 1, 0);
        SinglyLinkedListUtil.addNode(head, 3, 0);
        SinglyLinkedListUtil.addNode(head, 1, 0);
        SinglyLinkedListUtil.addNode(head, 1, 0);
        SinglyLinkedListUtil.addNode(head, 4, 0);
        SinglyLinkedListUtil.addNode(head, 7, 0);

        SinglyLinkedListUtil.printList(head);

        head = Problem203.removeElements(head, 0);

        SinglyLinkedListUtil.printList(head);
    }

}
