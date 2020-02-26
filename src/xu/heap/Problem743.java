package xu.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 此题可以使用迪克斯特拉算法来解决
 */

public class Problem743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = 10000;
            }
        }
        for (int[] time : times) {
            graph[time[0]-1][time[1]-1] = time[2];
        }
        int[] dist = new int[N];
        int[] visited = new int[N];
        Arrays.fill(dist, 10000);
        dist[K-1] = 0;
        for (int i = 0; i < N - 1; i++) {
            int vert = getMinVert(dist, visited);
            visited[vert] = 1;
            for (int j = 0; j < N; j++) {
                if (visited[j] == 0 &&
                        graph[vert][j] + dist[vert] < dist[j]){
                    dist[j] = graph[vert][j] + dist[vert];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == 10000)
                return -1;
            if (dist[i] > max)
                max = dist[i];
        }
        return max;
    }

    private int getMinVert(int[] dist, int[] visited) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < min && visited[i] == 0){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(new Problem743().networkDelayTime(new int[][]{
                {3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},
            {1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},
            {2,5,4},{4,2,51},{3,1,36},{2,3,59}
        }, 5, 5));
    }
}
