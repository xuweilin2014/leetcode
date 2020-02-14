package xu.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Problem210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int val = prerequisites[i][0];
            indegree[val]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        int counter = 0;
        while (!queue.isEmpty()){
            int val = queue.poll();
            res[counter] = val;
            counter++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == val){
                    if ((--indegree[prerequisites[i][0]]) == 0){
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        if (counter != numCourses)
            return new int[0];
        return res;
    }

    public static void main(String[] args) {
        int[] order = new Problem210().findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        });
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");
        }
    }
}
