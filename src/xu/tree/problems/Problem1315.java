package xu.tree;

public class Problem1315 {

    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        sum = DFS(root, null, null, sum);
        return sum;
    }

    public int DFS(TreeNode cur, TreeNode parent, TreeNode grandParent, int sum){
        if (cur == null)
            return sum;

        if (grandParent != null && grandParent.val % 2 == 0){
            sum += cur.val;
        }

        sum = DFS(cur.left, cur, parent, sum);
        sum = DFS(cur.right, cur, parent, sum);

        return sum;
    }


}
