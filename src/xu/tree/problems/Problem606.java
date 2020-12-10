package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.text.DateFormatSymbols;

public class Problem606 {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";

        if (t.left == null && t.right == null)
            return "" + t.val;

        String str = "" + t.val;
        str = func(t.left, str, 0);
        str = func(t.right,str,1);
        return str;
    }

    private String func(TreeNode t, String s, int OP) {
        if (t == null){
            if (OP == 0)
                return s + "()";
            else
                return s;
        }

        if (t.left == null && t.right == null){
            return s + "(" + t.val + ")";
        }

        s += "(" + t.val;
        s = func(t.left, s,0);
        s = func(t.right, s,1);
        s += ")";
        return s;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,3,4,null,null,null});
        TreeUtil.printTree(root);
        System.out.println();
        System.out.println(new Problem606().tree2str(root));
    }
}
