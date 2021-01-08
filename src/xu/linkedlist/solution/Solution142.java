package xu.linkedlist.solution;

public class Solution142 {
    /*
     * 环形链表 II
     * 这道题目使用快慢指针，定义两个指针 slow 和 fast，其中 slow 每次往后移动一个节点，fast 往后移动两个节点。
     * 如果链表中存在圆环，那么 slow 和 fast 指针肯定会相遇。假设 slow 指针移动的距离是 s，fast 指针移动的距离
     * 是 f，并且 slow 指针进入圆环以后，又走了 m 长度和 fast 指针相遇，最后假设圆环的长度为 L:
     *
     * f = 2s (1)
     * f - s = nL (2)
     * 1 式和 2 式 => s = nL => s - m = (n - 1)L + L - m
     *
     * 所以再令一个指针 cur 从链表的头结点开始往后遍历，每次向后移动一个结点，同时 slow 指针继续从和 fast 指针相遇
     * 的结点向后移动。最后 cur 指针和 slow 指针相遇的地方就是链表的入口节点。此时 slow 指针所走的距离为
     * (n - 1)L + L - m，而 cur 指针所走的距离为 s - m。
     */
}
