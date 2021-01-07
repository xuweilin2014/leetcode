package xu.linkedlist.solution;

public class Solution143 {
    /*
     * 重排链表
     * 这道题目首先遍历一遍链表，并且使用数组将链表中遍历到的每个节点保存到其中。然后使用两个指针，
     * 一个是 cur 指向链表中的头节点，另外一个是 counter，指向数组中的最后一个节点。然后把 counter
     * 指向的每一个节点保存到 cur 指针指向的后面一个，直到 cur 和 counter 指向的结点相同，或者
     * counter 指向的节点是 cur 的后面一个结点，即 cur.next = nodes[counter]
     */
}
