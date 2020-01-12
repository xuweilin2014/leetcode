package xu.linkedlist;

import javax.sound.sampled.Line;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(56);
        linkedList.get(1);
        linkedList.addAtIndex(1,50);
        linkedList.deleteAtIndex(1);
        linkedList.get(1);
        linkedList.addAtIndex(1,43);
        linkedList.addAtHead(82);
        linkedList.get(2);
        linkedList.deleteAtIndex(3);
        linkedList.get(1);
        linkedList.deleteAtIndex(41);
        linkedList.printLinkedList();
    }
}
