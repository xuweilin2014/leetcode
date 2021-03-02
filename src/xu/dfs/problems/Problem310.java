package xu.dfs.problems;

import java.util.*;

public class Problem310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 如果只有一个结点，那么它就是最小高度树
        if (n == 1){
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        return func(n, edges);
    }

    public List<Integer> func(int n, int[][] edges){
        // degree 是图中各个结点的度的数组
        int[] degree = new int[n];
        // 采用邻接表的方式存储图
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            // 对于每一条边上的两个点，度都加一
            degree[edge[0]] += 1;
            degree[edge[1]] += 1;
            // 添加每一个顶点的邻接点到图中
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        Queue<Integer> queue = new ArrayDeque<>();
        // 把所有度为 1 的结点添加到 queue 中，这些度为 1 的结点可以看成是叶子结点
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1)
                queue.offer(i);
        }
        // 结果队列，其实就是用来存储图中的叶子结点（度只有 1 的结点）
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // val 就是图中的叶子结点，或者说度为 1 的结点
                int val = queue.poll();
                res.add(val);
                // 获取叶子结点的所有邻接点
                List<Integer> set = graph.get(val);
                // 遍历所有的邻接点，将这些邻接点的度都减一，类似于拓扑排序
                for (Integer point : set) {
                    degree[point]--;
                    if (degree[point] == 1){
                        queue.add(point);
                    }
                }
            }
        }

        return res;
    }



    public static void main(String[] args) {
        System.out.println(new Problem310().findMinHeightTrees(6, new int[][]{
                {3,0},{3,1},{3,2},{3,4},{5,4}
        }));
        System.out.println(new Problem310().findMinHeightTrees(3, new int[][]{
                {0,1},{1,2}
        }));
    }
}
