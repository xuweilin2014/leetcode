package xu.tree;

public class Problem1026 {
    private int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode cur, int min, int max){
        if (cur == null)
            return max - min;

        if (cur.val < min)
            min = cur.val;
        else if (cur.val > max)
            max = cur.val;

        if (cur.left == null && cur.right == null)
            return max - min;

        int left = helper(cur.left, min, max);
        int right = helper(cur.right, min, max);
        return Math.max(left, right);
    }

    private void func(TreeNode cur) {
        if (cur == null)
            return;

        Pair pair = findMinMax(cur, Integer.MAX_VALUE, Integer.MIN_VALUE);
        if (cur.val - pair.min > max){
            max = cur.val - pair.min;
        }
        if (max < pair.max - cur.val)
            max = pair.max - cur.val;

        func(cur.left);
        func(cur.right);
    }

    private Pair findMinMax(TreeNode cur, int min, int max){
        if (cur == null)
            return new Pair(min, max);

        if (cur.val < min){
            min = cur.val;
        }
        if (cur.val > max)
            max = cur.val;

        Pair left = findMinMax(cur.left, min, max);
        Pair right = findMinMax(cur.right, min, max);


        return new Pair(Math.min(left.min, right.min),
                Math.max(left.max, right.max));
    }

    class Pair{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{2,null,0,1,null});
        System.out.println(new Problem1026().maxAncestorDiff(root));
    }
}
