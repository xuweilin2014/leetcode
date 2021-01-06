package xu.linkedlist.solution;

public class Solution83 {
    /*
     * 删除排序链表中的重复元素
     * 比 82 题要简单一些，不过基本思想一样，这一题只需要两个指针 p，pp。其中 p 指针指向 head，pp 指针指向
     * head.next。遍历的时候也是分三种情况来进行讨论：
     *
     * 1.p.val == pp.val，那么 pp 向后移动
     * 2.p.val != pp.val and p.next == pp，那么 p 和 pp 指针直接向后移动
     * 3.p.val != pp.val and p.next != pp，那么说明 p 和 pp 指针之间有相同的结点，那么就令 p.next = pp，
     * 然后 p 和 pp 指针都想就移动
     */
}
