package xu.graph.solutions;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution207 {

    /*
     * 207 课程表
     *
     * 这道题目就是需要使用拓扑排序判断有向图中是否存在环。解题的步骤如下：
     * 1.创建一个入度数组，用来保存有向图中各个顶点的入度大小
     * 2.
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1.创建一个入度数组，用来保存有向图中各个顶点的入度大小
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
        }

        // 2.创建一个队列 queue 中，将入度数组中入度为 0 的顶点保存到队列 queue 中
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        // 3.将 queue 中入度为 0 的顶点依次取出，然后将和其关联的顶点的入度依次减一，如果有新的顶点的
        //  入度变为 0，那么就将这些新的顶点保存到 queue 中，进行下次循环
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

}
