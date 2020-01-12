package xu.linkedlist;

//problem 707

public class MyLinkedList {

    private Node head;
    private int length;

    private static class Node{
        private int val;
        private Node next;
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
        head.next = null;
        length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index > length - 1){
            return -1;
        }
        Node p = head;
        int i = -1;
        while (i < index){
            p = p.next;
            i++;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node();
        node.next = head.next;
        head.next = node;
        node.val = val;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node();
        node.val = val;
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > length){
            return;
        }
        Node p = head;
        int i = -1;
        while (i < index - 1){
            i++;
            p = p.next;
        }
        Node anode = new Node();
        anode.val = val;
        anode.next = p.next;
        p.next = anode;
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > length - 1){
            return;
        }
        Node p = head;
        int i = 0;
        while (i < index){
            p = p.next;
            i++;
        }
        p.next = p.next.next;
        length--;
    }

    public void printLinkedList(){
        Node p = head.next;
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
