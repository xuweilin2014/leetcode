package xu.linkedlist;

/**
 * 237. Delete Node in a Linked List
 */

public class Problem237 extends SinglyLinkedListUtil{

    public static void deleteNode(ListNode node) {
        if (node == null)
            return;
        
        ListNode prev = null;
        ListNode cur = node;
        ListNode next = node.next;
        
        while (next != null){
            prev = cur;
            cur.val = next.val;
            cur = next;
            next = next.next;
        }
        
        prev.next = null;
    }

}
