package xu.dfs.solutions;

import java.util.*;

public class Solution310 {

//    private List<Integer> res = new ArrayList<>();
//
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        return solution(n, edges);
//    }
//
//    public List<Integer> solution(int n, int[][] edges){
//        if (n == 1)
//            return Collections.singletonList(0);
//
//        List<Set<Integer>> vert = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) vert.add(new HashSet<>());
//        for (int[] edge : edges) {
//            vert.get(edge[0]).add(edge[1]);
//            vert.get(edge[1]).add(edge[0]);
//        }
//        List<Integer> leaves = new ArrayList<>();
//        for (int i = 0; i < vert.size(); i++) {
//            if (vert.get(i).size() == 1) leaves.add(i);
//        }
//
//        while (n > 2){
//            n -= leaves.size();
//            List<Integer> newLeaves = new ArrayList<>();
//            for (Integer leaf : leaves) {
//                Integer next = vert.get(leaf).iterator().next();
//                vert.get(next).remove(leaf);
//                if (vert.get(next).size() == 1) newLeaves.add(next);
//            }
//            leaves = newLeaves;
//        }
//
//        return leaves;
//    }

}
