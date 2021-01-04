package xu.linkedlist.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. Reorder List
 */
public class Problem143 extends SinglyLinkedListUtil{

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null
                || head.next.next == null)
            return;

        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;

        while (node != null){
            nodes.add(node);
            node = node.next;
        }

        int begin = 0;
        int end = nodes.size() - 1;
        ListNode endLast;

        while (begin != end - 1 && begin != end){
            endLast = nodes.get(end - 1);
            ListNode beginNode = nodes.get(begin);
            ListNode endNode = nodes.get(end);
            endNode.next = beginNode.next;
            beginNode.next = endNode;
            endLast.next = null;
            begin++;
            end--;
        }
    }

    public static void reorderListFinal(ListNode head){
        if (head == null || head.next == null
                || head.next.next == null)
            return;

        //使用两个指针slow和fast，把链表分成两个部分
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode ListHead2 = slow.next;
        slow.next = null;

        ListHead2 = reverseList(ListHead2);
        mergeTwoList(head, ListHead2);
    }

    private static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;

        ListNode h1 = head1, h2 = head2;
        ListNode hnext1, hnext2;
        while (h1 != null && h2 != null){
            hnext1 = h1.next;
            hnext2 = h2.next;
            h1.next = h2;
            h2.next = hnext1;
            h1 = hnext1;
            h2 = hnext2;
        }

        return head1;
    }

    private static ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        ListNode cur = head, next, prev = null;

        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        /*ListNode head1 = new ListNode(2);
        Problem143.addNode(head1, 1, 0);
        Problem143.addNode(head1, 3, 0);
        Problem143.addNode(head1, 5, 0);

        ListNode head2 = new ListNode(6);
        Problem143.addNode(head2, 4, 0);
        Problem143.addNode(head2, 7, 0);

        ListNode head = Problem143.mergeTwoList(head1, head2);

        Problem143.printList(head);*/

        ListNode head1 = new ListNode(2);
        Problem143.addNode(head1, 1, 0);
        Problem143.addNode(head1, 3, 0);
        Problem143.addNode(head1, 5, 0);
        /*Problem143.addNode(head1, 6, 0);
        Problem143.addNode(head1, 4, 0);
        Problem143.addNode(head1, 7, 0);*/

        Problem143.reorderListFinal(head1);

        Problem143.printList(head1);
    }


}
