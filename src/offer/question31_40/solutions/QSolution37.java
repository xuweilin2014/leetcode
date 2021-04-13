package offer.question31_40.solutions;

import xu.tree.problems.TreeNode;

public class QSolution37 {

    /*
     * 序列化和反序列化二叉树
     *
     * 这道题目在进行序列化时，只能使用层序遍历或者说前序遍历进行序列化，然后再进行反序列化才能够还原二叉树。这里以先序遍历为例。
     * 反序列化时，也是先按照先序遍历的方式，先遍历到的结点看成是根结点，创建一个 root，然后如果这个节点是 $，即为 null,那么
     * 直接返回，否则，按如下顺序接着进行遍历：
     *
     * root.left = func(serialize path)
     * root.right = func(serialize path)
     *
     */

    private int index = -1;

    public String Serialize(TreeNode root) {
        if (root == null)
            return "$" + ",";

        String tree = root.val + ",";
        tree += Serialize(root.left);
        tree += Serialize(root.right);

        return tree;
    }

    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0)
            return null;

        String[] strings = str.split(",");
        return func(strings);
    }

    private TreeNode func(String[] strings){
        if (index == strings.length)
            return null;

        index++;
        TreeNode root = null;
        if (!"$".equals(strings[index])){
            root = new TreeNode(Integer.parseInt(strings[index]));
            root.left = func(strings);
            root.right = func(strings);
        }

        return root;
    }
}
