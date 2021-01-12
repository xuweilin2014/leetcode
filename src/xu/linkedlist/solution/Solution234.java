package xu.linkedlist.solution;

public class Solution234 {
    /*
     * 回文链表
     * 要求使用 O(N) 时间复杂度，以及 O(1) 空间复杂度。可以首先使用快慢指针，求出链表的中间节点，将链表的后半段直接翻转，
     * 从链表的头结点和链表的尾结点开始进行遍历，比较数值是否相等。这里最关键的一点就是遍历比较的终止条件，应该是
     * head.next != last && head != last。
     * 当链表中结点的个数为奇数个时，终止条件为 head != last，
     * 当链表中节点的个数为偶数个时，终止条件为 head.next != last
     */
}
