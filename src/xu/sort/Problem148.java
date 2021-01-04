package xu.sort;

import xu.linkedlist.problems.ListNode;
import xu.linkedlist.problems.SinglyLinkedListUtil;

public class Problem148 {
    public ListNode sortList(ListNode head) {
        head = helper(head);
        return head;
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode h1 = helper(head);
        ListNode h2 = helper(tmp);
        ListNode dummy = new ListNode(0);
        ListNode h3 = dummy;
        while (h1 != null && h2 != null){
            if (h1.val < h2.val){
                h3.next = h1;
                h3 = h1;
                h1 = h1.next;
            }else{
                h3.next = h2;
                h3 = h2;
                h2 = h2.next;
            }
        }
        while (h1 != null){
            h3.next = h1;
            h3 = h1;
            h1 = h1.next;
        }
        while (h2 != null){
            h3.next = h2;
            h3 = h2;
            h2 = h2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        SinglyLinkedListUtil.addNode(head, 2, 0);
        SinglyLinkedListUtil.addNode(head, 1, 0);
        SinglyLinkedListUtil.addNode(head, 3, 0);
        ListNode node = new Problem148().sortList(head);
        SinglyLinkedListUtil.printList(node);
    }
}
