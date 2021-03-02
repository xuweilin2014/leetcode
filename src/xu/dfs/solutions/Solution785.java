package xu.dfs.solutions;

import java.util.HashSet;
import java.util.Set;

public class Solution785 {

    /*
     * 判断二分图
     *
     * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，
     * 一个来自 B 集合，就将这个图称为 二分图 。
     *
     * 其实这道题目类似于图的深度优先搜索的一个变种，一般在 dfs 遍历无向图的过程中，会有一个集合 visited 避免重复遍历，
     * 现在这里则需要两个集合 va 和 vb，分别表示二分图中的两个顶点集合。在遍历的过程中，除了需要注意不能遍历已经访问
     * 过的结点之外，还需要判断当前节点和它的邻接点是否位于一个顶点集合中，如果是的话，就表明不是二分图。
     */

    private Set<Integer> sa = new HashSet<>();
    private Set<Integer> sb = new HashSet<>();
    private boolean ans = true;

    private boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return false;

        for (int i = 0; i < graph.length; i++) {
            if (!sa.contains(i) && !sb.contains(i)){
                dfs(i, graph, true);
            }
        }

        return ans;
    }

    private void dfs(int v, int[][] graph, boolean isa) {
        if (isa)
            sa.add(v);
        else
            sb.add(v);
        int[] vs = graph[v];

        for (int point : vs) {
            if ((isa && sa.contains(point))
                    || (!isa && sb.contains(point))){
                ans = false;
                return;
            }

            if (!sa.contains(point) && !sb.contains(point)){
                dfs(point, graph, !isa);
            }
        }
    }

}
