package xu.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;

        List<Integer> list = new ArrayList<>();
        DFSGetAll(list, root1);
        DFSGetAll(list, root2);
        Collections.sort(list);
        return list;
    }

    private void DFSGetAll(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        list.add(root.val);
        DFSGetAll(list, root.left);
        DFSGetAll(list, root.right);
    }


}
