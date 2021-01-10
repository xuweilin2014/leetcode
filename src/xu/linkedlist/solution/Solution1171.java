package xu.linkedlist.solution;

public class Solution1171 {
    /*
     * 从链表中删去总和值为零的连续节点
     *
     * 这道题目使用前缀和的思想。
     *
     * 具体是第一次遍历使用 hashmap 来实现前缀和，键值对为 <prefixSum, ListNode>
     * 具体就是遍历到某一个节点时，当前的前缀和 sum，以及当前的 ListNode。如果同一前缀和出现多次会被
     * 覆盖，也就是记录该 sum 最后一次出现的节点。
     *
     * 第二次遍历，如果遍历到的当前节点的前缀和 sum 在 hashmap 中出现，那么就表明两个结点区间中的所有
     * 节点的值之和为 0，则删除区间
     */
}
