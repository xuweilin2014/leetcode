package xu.graph.problems;

import java.util.*;

public class Problem207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int counter = 0;
        while (!queue.isEmpty()){
            int val = queue.poll();
            counter++;
            for (int[] pre : prerequisites) {
                if (pre[1] == val){
                    indegree[pre[0]]--;
                    if (indegree[pre[0]] == 0)
                        queue.offer(pre[0]);
                }
            }
        }

        return counter == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(new Problem207().canFinish(5, new int[][]{
                {1, 4}, {2, 4}, {3, 1}, {3, 2}
        }));
    }

}
