package xu.dfs.solutions;

import java.util.*;

public class Solution310 {

    /*
     * 首先，我们看了样例，发现这个树并不是二叉树，是多叉树。然后，我们可能想到的解法是：根据题目的意思，就挨个节点遍历bfs，统计下每个节点
     * 的高度，然后用map存储起来，后面查询这个高度的集合里最小的就可以了。
     *
     * 但是这样会超时的。于是我们看图（题目介绍里面的图）分析一下，发现，越是靠里面的节点越有可能是最小高度树。
     *
     * 所以，我们可以这样想，我们可以倒着来。我们从边缘开始，先找到所有度为1的节点，然后把所有度为1的节点进队列，然后不断地bfs，最后找
     * 到的就是两边同时向中间靠近的节点，那么这个中间节点就相当于把整个距离二分了，那么它当然就是到两边距离最小的点啦，也就是到其他叶子节点最近的节点了。
     */

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


}
