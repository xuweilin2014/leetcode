package xu.dfs;

import xu.linkedlist.ListNode;
import xu.linkedlist.Problem1171;
import xu.linkedlist.SinglyLinkedListUtil;

public class Problem430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null)
            return head;

        dfs(head);
        return head;
    }

    private Node dfs(Node cur) {
        Node prev = cur;
        while (cur != null){
            if (cur.child != null){
                Node first = cur.child;
                Node last = dfs(cur.child);
                first.prev = cur;
                last.next = cur.next;
                if (cur.next != null)
                    cur.next.prev = last;
                cur.next = first;
                cur.child = null;
            }
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}
