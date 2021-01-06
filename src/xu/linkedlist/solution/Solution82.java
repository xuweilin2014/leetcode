package xu.linkedlist.solution;

public class Solution82 {
    /*
     * 删除排序链表中的重复元素 II
     * 这道题目想法并不难，只是过程有点麻烦。由于有 1 1 1 2 3 这种情况需要删除最开始的结点，所以这里
     * 要加上一个哑结点来简化我们的处理。这里需要使用到三个指针，prev, p, pp，其中 prev 最开始是指向
     * 哑结点，p 指向 head 结点，pp 指向 head 结点的下一个结点。接下来需要分 3 种情况来处理：
     *
     * 1.p.val == pp.val，那么 pp 指针就接着向后移动
     * 2.p.val != pp.val and p.next == pp，那么 prev、p、pp 指针都直接向后移动
     * 3.p.val 1= pp.val and p.next != pp，那么就说明 p 和 pp 指针之间有相同的节点，所以 prev.next = pp，然后
     * p = pp，同样的 pp 指针向后移动一个位置
     */
}
