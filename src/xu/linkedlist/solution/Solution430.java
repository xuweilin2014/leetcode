package xu.linkedlist.solution;

public class Solution430 {
    /*
     * 扁平化多级双向链表
     *
     * 这道题目直觉上使用 dfs 来解决，但是有一种比较简单的方法来解决。就是在遍历的过程中，如果碰到一个结点的
     * child 不为 null，那么就把这个子链表并入到当前链表中。接着遍历下一个结点，注意这个节点在这里就是刚刚
     * 并入的子链表的一个结点，然后不断遍历，把子链表并入，就可以得到最终的结果
     */
}