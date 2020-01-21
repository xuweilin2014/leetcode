package xu.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 */

public class Problem138 extends SinglyLinkedList{

    public static Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        List<Node> randomPointers = new ArrayList<>();
        List<Node> nodeAddre = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        Node node = (Node) head.next;
        randomPointers.add(head.random);
        nodeAddre.add(head);
        Node oldNode = new Node(head.val);
        nodes.add(oldNode);

        while (node != null){
            randomPointers.add(node.random);
            nodeAddre.add(node);
            Node newNode = new Node(node.val);
            nodes.add(newNode);
            node = (Node) node.next;
        }

        for (long i = 0; i < nodes.size(); i++) {
            long randomIndex = getRandomIndex(randomPointers.get((int) i), nodeAddre);
            if (randomIndex == -1){
                nodes.get((int) i).random = null;
            }else{
                nodes.get((int) i).random = nodes.get((int) randomIndex);
            }
        }

        for (int i = 0; i < nodes.size() - 1; i++){
            nodes.get(i).next = nodes.get(i + 1);
        }

        return nodes.get(0);

    }

    private static long getRandomIndex(Node node, List<Node> nodeAddre) {

        if (node == null){
            return -1;
        }else {
            return nodeAddre.indexOf(node);
        }

    }

    public Node copyRandomListFinal(Node head){
        if (head == null){
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node node = head;

        while (node != null){
            Node anode = new Node(node.val);
            map.put(node, anode);
            node = (Node) node.next;
        }

        node = head;
        while (node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = (Node) node.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Problem138.addNode(head, 3, 1);
        Problem138.addNode(head, 3, 1);

        Problem138.printList(head);

        Node newHead = Problem138.copyRandomList(head);

        Problem138.printList(newHead);
    }

}
