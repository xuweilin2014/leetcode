package xu.linkedlist.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * 复制带随机指针的链表，最直接的办法是使用哈希表，存储原来链表 node 节点和新链表 node 节点
 * 的对应关系
 */
public class Problem138{

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> nodes = new HashMap<>();
        Node dummy = new Node(0);
        Node p = dummy;
        Node cur = head;
        while (cur != null){
            Node node = new Node(cur.val);
            p.next = node;
            p = node;
            nodes.put(cur, node);
            cur = cur.next;
        }
        p.next = null;

        cur = head;
        p = dummy.next;
        while (cur != null){
            p.random = nodes.get(cur.random);
            p = p.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
