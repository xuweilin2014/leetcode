package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.*;

public class Problem501 {
    private TreeNode prev = null;
    private int counter = 0;
    private int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        if (root.left == null && root.right == null)
            return new int[]{root.val};

        List<Integer> vals = new LinkedList<>();
        func(root, vals);
        int[] modes = new int[vals.size()];
        for (int i = 0; i < modes.length; i++) {
            modes[i] = vals.get(i);
        }
        return modes;
    }

    private void func(TreeNode cur, List<Integer> modes) {
        if (cur == null)
            return;
        
        func(cur.left, modes);
        if (prev == null || prev.val == cur.val){
            counter++;
        }else{
            counter = 1;
        }

        if (counter == max){
            modes.add(cur.val);
        }else if (counter > max){
            modes.clear();
            modes.add(cur.val);
            max = counter;
        }

        prev = cur;
        func(cur.right, modes);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,1,2,null,null,2,null});
        for (int i = 0; i < new Problem501().findMode(root).length; i++) {
            System.out.print(new Problem501().findMode(root)[i] + " ");
        }
    }
}
