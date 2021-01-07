package xu.linkedlist.solution;

public class Solution160 {
    /*
     * 相交链表
     * 这道题目的思想很简单，定义两个指针 curA，curB，分别指向链表 A 和 链表 B 的头结点。当 curA 遍历到链表的
     * 尾结点时，再从链表 B 的头结点开始遍历，对于 curB 也是一样，遍历到链表的尾结点时，再从链表 A 的头结点开始。
     * 直到 curA = curB。而最后的结果分两种情况：
     *
     * 1.当链表 A,B 有相交时，那么最后返回的结果就是 A,B 相交的结点
     * 2.当链表 A,B 不相交时，那么最后返回的结果就是 null，也就 curA = curB = null
     */
}
