package algorithm_analysis_and_design.dynamic_programming;

import java.util.*;

public class MultiSegmentGraph {

    public static void main(String[] args) {
        backPath(new int[][]{
                {-1,4,2,3,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,9,8,-1,-1,-1,-1},
                {-1,-1,-1,-1,6,7,8,-1,-1,-1},
                {-1,-1,-1,-1,-1,4,7,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,5,6,-1},
                {-1,-1,-1,-1,-1,-1,-1,8,6,-1},
                {-1,-1,-1,-1,-1,-1,-1,6,5,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,7},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,3},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        });
    }

    public static void backPath(int[][] edge){
        int[] cost = new int[edge.length];
        int[] path = new int[edge.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;

        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge.length; j++) {
                if (edge[i][j] != -1){
                    if (edge[i][j] + cost[i] < cost[j]){
                        cost[j] = edge[i][j] + cost[i];
                        path[j] = i;
                    }
                }
            }
        }

        System.out.println("图的最短路径为：" + cost[edge.length - 1]);

        List<Integer> stack = new ArrayList<>();
        stack.add(edge.length - 1);
        for (int i = edge.length - 1; i > 0;) {
            stack.add(path[i]);
            i = path[i];
        }
        Collections.reverse(stack);
        System.out.println("最短路径为：" + stack);

    }
 
}
