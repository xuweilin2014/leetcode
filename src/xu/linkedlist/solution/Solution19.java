package xu.linkedlist.solution;

public class Solution19 {
    /*
     * 删除链表的倒数第 n 个节点
     * 这道题目也是一个使用快慢指针的例子，基本的思想就是定义两个指针 fast 和 slow，首先 fast 指针先移动
     * n 次，然后 fast 指针和 slow 指针都移动到链表的末尾。由于 fast 和 slow 指针之间的距离一直保持为 n，
     * 所以当 fast 到达链表的末尾时，slow 指针到达了链表的倒数第 n 个节点。这里需要注意一个特殊情况就是这个
     * 倒数第 n 个节点的 n 等于链表的长度，也就是要删除链表的第一个结点，这就需要创建一个哑结点，用来简化代码
     */
}
