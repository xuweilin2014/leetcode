package offer.question31_40.solutions;

public class QSolution35 {

    /*
     * 复杂链表的复制
     *
     * 这道题目需要使用哈希的解法，时间复杂度 O(N)，空间复杂度 O(N)。首先重新创建一个链表，这个新链表中的节点值和原始链表中
     * 节点的值相同，并且在创建新链表的过程中，将旧链表和新链表中的节点保存到 map 中，<旧 Node, 新 Node> -> map，
     * 第二次遍历的时候，遍历到某一个节点 cur，那么可以从 map 中获得它的 random 指针指向的 Node，同时也可以获得这个
     * 原始链表中的 Node 对应的新链表中的 Node，获取到新链表中的 Node 之后，就可以设置到新链表节点的 random 指针。
     */

}
