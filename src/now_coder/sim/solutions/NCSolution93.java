package now_coder.sim.solutions;

import now_coder.sim.ncs.NC93;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NCSolution93 {

    /*
     * 实现 LRU 缓存
     *
     * 实现 LRU 缓存的基本结构就是【双向链表 + hashmap】，双向链表的基本结构是 dummy - tail，也就是双向链表作为空链表的话，只有两个
     * 基本结点 head 和 tail。链表中的第一个元素表示最常访问的元素，而最后一个元素表示的就是最近最不常访问的元素。
     *
     * 1.当添加一个元素时：
     *     如果链表以达到容量上限，那么就将链表尾部的元素移除掉，然后添加节点搭到链表中
     *     如果链表没有达到容量的上限，那么直接添加
     * 2.当访问一个元素时，如果这个元素在链表中存在的话，就会把这个元素移动到链表头部
     */

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
    
}
