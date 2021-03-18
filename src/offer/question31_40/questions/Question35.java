package offer.question31_40.questions;

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

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node p = head;
        Node dummy = new Node(0);
        Node pc;
        Node prev = null;
        Map<Node, Node> map = new HashMap<>();

        while (p != null){
            pc = new Node(p.val);
            if (prev != null){
                prev.next = pc;
            }
            if (dummy.next == null){
                dummy.next = pc;
            }
            map.put(p, pc);
            prev = pc;
            p = p.next;
        }

        pc = dummy.next;
        p = head;
        while (p != null){
            Node random = p.random;
            if (random != null)
                pc.random = map.get(random);
            pc = pc.next;
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

        System.out.println(new Question35().copyRandomList(node1));
    }

}
