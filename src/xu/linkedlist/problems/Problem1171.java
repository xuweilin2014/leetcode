package xu.linkedlist.problems;

import java.util.*;

/**
 * 1171. Remove Zero Sum Consecutive Nodes from Linked List
 */
public class Problem1171{

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null){
            return null;
        }

        Map<Integer, ListNode> prefix = new HashMap<>();
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (ListNode cur = dummy; cur != null; cur = cur.next){
            sum += cur.val;
            prefix.put(sum, cur);
        }

        sum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next){
            sum += cur.val;
            cur.next = prefix.get(sum).next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, -3, 3, -3, 4, -2, -2, 7});
        SinglyLinkedListUtil.printList(new Problem1171().removeZeroSumSublists(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, -3, 4, -2, -2});
        SinglyLinkedListUtil.printList(new Problem1171().removeZeroSumSublists(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1,3,2,-3,-2,5,5,-5,1});
        SinglyLinkedListUtil.printList(new Problem1171().removeZeroSumSublists(node));
    }
}
