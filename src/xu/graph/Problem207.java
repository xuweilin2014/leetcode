package xu.graph;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
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
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem207().
                canFinish(2, new int[][]{
                {1, 0}
        }));
    }
}
