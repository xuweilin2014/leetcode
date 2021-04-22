package xu.graph.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int[] ans = new int[numCourses];
        int counter = 0;
        while (!queue.isEmpty()){
            Integer val = queue.poll();
            ans[counter++] = val;

            for (int[] pre : prerequisites) {
                if (pre[1] == val){
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0)
                        queue.offer(pre[0]);
                }
            }
        }

        if (counter != numCourses)
            return new int[0];
        return ans;
    }

    public static void main(String[] args) {
        int[] order = new Problem210().findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        });
        for (int value : order) {
            System.out.print(value + " ");
        }
    }
}
