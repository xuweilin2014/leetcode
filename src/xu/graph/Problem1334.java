package xu.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1334 {

    private int[][] graph;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        for (int v = 0; v < n; v++) {
            for (int w = 0; w < n; w++) {
                if (v == w)
                    graph[w][w] = 0;
                else if (graph[v][w] == 0)
                    graph[v][w] = 10000;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int v = 0; v < n; v++) {
                for (int w = 0; w < n; w++) {
                    if (graph[v][i] + graph[i][w] < graph[v][w])
                        graph[v][w] = graph[v][i] + graph[i][w];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minv = 0;
        for (int v = 0; v < n; v++) {
            int counter = 0;
            for (int w = 0; w < n; w++) {
                if (graph[v][w] <= distanceThreshold)
                    counter++;
            }
            if (min >= counter) {
                minv = v;
                min = counter;
            }
        }
        return minv;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1334().findTheCity(5, new int[][]{
                {0, 1, 2}, {0,4,8}, {1,2,3}, {1,4,2},{2,3,1},{3,4,1}
        }, 2));
    }
}
