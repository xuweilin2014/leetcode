package xu.dfs.problems;

import java.util.*;

/**
 * This problem wants us to find the minimum height trees and return their root labels.
 * First we can think about a simple case -- a path graph.
 * For a path graph of n nodes, find the minimum height trees is trivial. Just designate
 * the middle point(s) as roots. Suppose we don't know n, nor do we have random access of the nodes.
 * We have to traversal. It is very easy to get the idea of two pointers.
 * One from each end and move at the same speed. When they meet or they are one step away,
 * (depends on the parity of n), we have the roots we want.
 */

public class Problem310 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        return solution(n, edges);
    }

    public List<Integer> solution(int n, int[][] edges){
        if (n == 1)
            return Collections.singletonList(0);

        List<Set<Integer>> vert = new ArrayList<>(n);
        for (int i = 0; i < n; i++) vert.add(new HashSet<>());
        for (int[] edge : edges) {
            vert.get(edge[0]).add(edge[1]);
            vert.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < vert.size(); i++) {
            if (vert.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Integer next = vert.get(leaf).iterator().next();
                vert.get(next).remove(leaf);
                if (vert.get(next).size() == 1) newLeaves.add(next);
            }
            leaves = newLeaves;
        }

        return leaves;
    }



    public static void main(String[] args) {
        System.out.println(new Problem310().findMinHeightTrees(3, new int[][]{
                {0,1},{1,2}
        }));
    }
}
