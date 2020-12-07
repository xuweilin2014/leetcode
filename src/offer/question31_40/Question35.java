package offer.question31_40;

import java.util.HashMap;
import java.util.Map;

public class Question35 {

    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 使用哈希的解法，时间复杂度 O(N)，空间复杂度 O(N)
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> func = new HashMap<>();
        Node ph = head;
        Node dummy = new Node(0);
        Node prev = dummy;
        Node p = dummy;
        while (ph != null){
            p = new Node(ph.val);
            prev.next = p;
            prev = p;

            func.put(ph, p);

            ph = ph.next;
        }

        p.next = null;
        p = dummy.next;
        ph = head;
        while (ph != null){
            if (ph.random == null)
                p.random = null;
            else
                p.random = func.get(ph.random);
            p = p.next;
            ph = ph.next;
        }

        return dummy.next;
    }

    // 使用修改原链表的方法，时间复杂度 O(N) 空间复杂度 O(1)
    public Node copyRandomList1(Node head) {
        if (head == null)
            return null;

        // 复制节点
        Node p = head;
        Node pnew;
        while (p != null){
            pnew = new Node(p.val);
            pnew.next = p.next;
            p.next = pnew;
            p = pnew.next;
        }

        // 复制原始节点的 random 值
        p = head;
        while (p != null){
            pnew = p.next;
            if (p.random == null)
                pnew.random = null;
            else
                pnew.random = p.random.next;
            p = pnew.next;
        }

        // 将链表一分为二
        Node dummy = new Node(0);
        p = head;
        pnew = dummy;
        while (p != null){
            pnew.next = p.next;
            pnew = p.next;
            p.next = pnew.next;
            p = p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        System.out.println(new Question35().copyRandomList1(node1));
    }

}
