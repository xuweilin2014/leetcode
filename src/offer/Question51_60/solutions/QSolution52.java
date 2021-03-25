package offer.Question51_60.solutions;

public class QSolution52 {
    /*
     * 两个链表的第一个公共节点
     *
     * 假设两个链表 l1 与 l2 的相交部分的长度为 c，l1 到相交部分的长度为 a，l2 到相交部分的长度为 b，那么分以下两种情况：
     *
     * i.如果 l1 与 l2 相交，那么 a + c + b = b + c + a
     * ii.如果 l1 与 l2 不相交，那么 a + b = b + a
     *
     * 所以具体的策略就是指针 pa 与 pb 分别在 l1 和 l2 上遍历，如果遍历到链表的尾结点，那么 pa 就从 l2 的头结点开始遍历，
     * pb 从 l1 的头结点开始遍历，最后如果相交，那么pa 与 pb 相遇的节点就是相交节点；如果不相交，那么 pa 与 pb 最后都会为 null
     */

}
