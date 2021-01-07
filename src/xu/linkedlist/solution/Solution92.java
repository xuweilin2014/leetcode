package xu.linkedlist.solution;

public class Solution92 {
    /*
     * 反转链表 II
     * 这道题目和【反转链表】都可以使用头插法来解决。由于 m 可能等于 1，所以需要创建一个哑结点来简化过程。
     * 首先需要两个指针 prev 和 p，最开始 prev 指向 dummy，p 指向 head。然后 prev 和 p 向后移动 m - 1
     * 次，使得 prev 指针正好指在 dummy 要反转的第 m 个节点的前一个节点。然后 p 接着开始遍历，每遍历到一个
     * 节点，都将这个节点插入到 prev 指针指向的节点和链表原第 m 个节点之间，一直到遍历完第 n 个节点。
     */
}
