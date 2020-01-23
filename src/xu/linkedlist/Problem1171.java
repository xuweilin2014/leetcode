package xu.linkedlist;

import java.util.*;

/**
 * 1171. Remove Zero Sum Consecutive Nodes from Linked List
 */
public class Problem1171 extends SinglyLinkedList {

    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        List<ListNode> nodes = new ArrayList<>();
        List<Integer> preIndex = new ArrayList<>();
        ListNode cur = dummy;
        int sum = 0;

        while (cur != null){
            sum += cur.val;
            nodes.add(cur);
            preIndex.add(sum);
            cur = cur.next;
        }

        for (int i = 0; i < preIndex.size(); i++) {
            int aPreIndex = preIndex.get(i);
            int indexOf = preIndex.lastIndexOf(aPreIndex);
            if (indexOf == i)
                continue;
            nodes.get(i).next = nodes.get(indexOf).next;
        }

        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        SinglyLinkedList.addNode(head, 3, 0);
        SinglyLinkedList.addNode(head, 2, 0);
        SinglyLinkedList.addNode(head, -3, 0);
        SinglyLinkedList.addNode(head, -2, 0);
        SinglyLinkedList.addNode(head, 5, 0);
        SinglyLinkedList.addNode(head, 5, 0);
        SinglyLinkedList.addNode(head, -5, 0);
        SinglyLinkedList.addNode(head, 1, 0);

        SinglyLinkedList.printList(head);

        head = Problem1171.removeZeroSumSublists(head);

        SinglyLinkedList.printList(head);
    }



}
