package offer.question31_40.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question37 {

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

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{10, 6, 14, 4, 8, 12, 16, null, null, null, 9});
        String str = new Question37().Serialize(node);
        System.out.println(str);
        TreeUtil.printTree(new Question37().Deserialize(str));
    }

}
