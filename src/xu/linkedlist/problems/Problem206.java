package xu.linkedlist.problems;

/**
 * 206. Reverse Linked List
 */
public class Problem206 extends SinglyLinkedListUtil{

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode p = cur.next;
            cur.next = prev;
            prev = cur;
            cur = p;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem206().reverseList(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2});
        SinglyLinkedListUtil.printList(new Problem206().reverseList(node));
    }

}
