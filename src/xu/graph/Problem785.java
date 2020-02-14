package xu.graph;

import java.util.*;

public class Problem785 {

    public boolean isBipartite(int[][] graph) {
        //visited[i]为0时表示没有遇到，1表示 white, 2表示black
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && visited[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = 1;
                while (!queue.isEmpty()){
                    int val = queue.poll();
                    for (int cur : graph[val]) {
                        if (visited[cur] == 0){
                            visited[cur] = (visited[val] == 1) ? 2 : 1;
                            queue.offer(cur);
                        }
                        if (visited[cur] == visited[val])
                            return false;

                    }
                }
            }
        }

        return true;
    }

    public boolean solution1(int[][] graph) {
        int counter = graph.length;
        int[] visited = new int[counter];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> s1 = set1;
        Set<Integer> s2 = set2;
        List<Integer> queue = new ArrayList<>();
        for (int k = 0; k < counter; k++) {
            if (graph[k].length != 0 && visited[k] == 0){
                queue.add(k);
                while (!queue.isEmpty()){
                    List<Integer> newQueue = new ArrayList<>();
                    for (Integer val : queue) {
                        s1.add(val);
                        visited[val] = 1;
                        for (int i = 0; i < graph[val].length; i++) {
                            if (visited[graph[val][i]] == 0){
                                if (s1.contains(graph[val][i]))
                                    return false;
                                s2.add(graph[val][i]);
                                newQueue.add(graph[val][i]);
                            }
                        }
                    }
                    queue = newQueue;
                    Set<Integer> tmp = s1;
                    s1 = s2;
                    s2 = tmp;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem785().isBipartite(new int[][]{
                {},{3},{4,5},{1},{2},{2}
        }));
    }
}
