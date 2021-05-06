package now_coder.sim.ncs;

import java.util.*;

public class NC93 {

    static class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node dummy = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private Map<Integer, Node> map = new HashMap<>();
    private int size = 0;

    public int[] LRU (int[][] operators, int k) {
        if (k == 0 || operators == null || operators.length == 0)
            return new int[0];

        dummy.next = tail;
        tail.prev = dummy;
        List<Integer> ans = new ArrayList<>();

        for (int[] operator : operators) {
            int op = operator[0];
            if (op == 1){
                addNode(operator[1], operator[2], k);
            }else {
                ans.add(getNode(operator[1]));
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private int getNode(int key) {
        Node node = map.get(key);

        if (node == null)
            return -1;
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.value;
        }
    }

    private void addNode(int key, int value, int k){
        if (size == k){
            removeNode();
        }

        Node node = new Node(key, value);
        moveToHead(node);
        size++;
        map.put(key, node);
    }

    private void moveToHead(Node node){
        node.next = dummy.next;
        dummy.next = node;
        node.prev = dummy;
        node.next.prev = node;
    }

    private void removeNode(){
        if (tail.prev != dummy){
            Node node = map.remove(tail.prev.key);
            size--;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NC93().LRU(new int[][]{
                {1,1,1}, {2,1}, {1,2,2}, {1,3,2}, {2,1}, {1,4,4}, {2,2}
        }, 3)));
    }

}
