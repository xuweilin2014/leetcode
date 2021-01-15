package xu.tree.solution;

public class Solution109 {

    /*
     * 有序链表转换二叉搜索树
     *
     * 将一个有序链表转换为高度平衡的二叉搜索树，首先使用快慢指针 slow,fast 确定链表的中点，最后 slow 指针就是
     * 链表的中点，可以把 slow 指针初始化为 root 结点，那么可以把 slow 结点的左侧和右侧分别当成是左子树和右子树，
     * 进行同样处理。
     *
     * root.left = func(head, slow) 左子树
     * root.right = func(slow.next, tail) 右子树
     */

}
