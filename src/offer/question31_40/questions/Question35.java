package offer.question31_40.questions;

import java.util.HashMap;
import java.util.Map;

public class Question35 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode p = head;
        RandomListNode prev = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null){
            RandomListNode node = new RandomListNode(p.label);

            if (prev != null)
                prev.next = node;

            map.put(p, node);
            p = p.next;
            prev = node;
        }

        p = head;
        while (p != null){
            map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(7);
        RandomListNode node2 = new RandomListNode(13);
        RandomListNode node3 = new RandomListNode(11);
        RandomListNode node4 = new RandomListNode(10);
        RandomListNode node5 = new RandomListNode(1);

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

        System.out.println(new Question35().Clone(node1));
    }

}
