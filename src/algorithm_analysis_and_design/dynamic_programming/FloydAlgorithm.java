package algorithm_analysis_and_design.dynamic_programming;

public class FloydAlgorithm {

    public static void main(String[] args) {
        int[][] dist = floyd(new int[][]{
                {0, 4, 11},
                {6, 0, 2},
                {3, Integer.MAX_VALUE, 0}
        });

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                System.out.printf("%2d ", dist[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] floyd(int[][] edge){
        int[][] dist = new int[edge.length][edge.length];

        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge.length; j++) {
                dist[i][j] = edge[i][j];
            }
        }

        for (int k = 0; k < edge.length; k++) {
            for (int i = 0; i < edge.length; i++) {
                for (int j = 0; j < edge.length; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        return dist;
    }

}
