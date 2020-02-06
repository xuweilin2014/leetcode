package xu.tree;

public class Problem222 {
    private int counter = 0;

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        func(root);
        return counter;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;

        counter++;
        func(root.left);
        func(root.right);
    }


}
