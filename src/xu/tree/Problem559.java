package xu.tree;

public class Problem559 {

    public static int maxDepth(Node root) {
        int depth = 0;
        depth = getDepth(root);
        return depth;
    }

    private static int getDepth(Node root) {
        if (root == null)
            return 0;

        if (root.children.size() == 0)
            return 1;

        int[] depths = new int[root.children.size()];
        for (int i = 0; i < root.children.size(); i++) {
            depths[i] = getDepth(root.children.get(i));
            depths[i] = depths[i] + 1;
        }

        return getMaxDepth(depths);
    }

    public static int getMaxDepth(int[] depths){
        if (depths.length == 0)
            return 0;

        int max = depths[0];
        for (int i = 0; i < depths.length; i++) {
            if (depths[i] > max)
                max = depths[i];
        }
        return max;
    }
}
