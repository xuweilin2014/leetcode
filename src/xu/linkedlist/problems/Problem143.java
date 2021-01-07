package xu.linkedlist.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. Reorder List
 */
public class Problem143{

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            nodes.add(cur);
            cur = cur.next;
        }

        int counter = nodes.size() - 1;
        cur = head;
        while (cur != nodes.get(counter) && cur.next != nodes.get(counter)){
            ListNode node = nodes.get(counter);
            if (counter - 1 < 0)
                return;
            ListNode prev = nodes.get(counter - 1);
            ListNode next = cur.next;
            cur.next = node;
            node.next = next;
            prev.next = null;
            cur = next;
            counter--;
        }
    }


    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        new Problem143().reorderList(node);
        SinglyLinkedListUtil.printList(node);
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        new Problem143().reorderList(node);
        SinglyLinkedListUtil.printList(node);
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4});
        new Problem143().reorderList(node);
        SinglyLinkedListUtil.printList(node);
    }


}
