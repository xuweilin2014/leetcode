package algorithm_analysis_and_design.backtracking;

/**
 * 使用回溯法来解决图的着色问题
 */

public class GraphColor {

    private int[][] graph = new int[][]{
            {0,1,1,0,0},{1,0,1,1,1},{1,1,0,0,1},{0,1,0,0,1},{0,1,1,1,0}
    };
    private static int[] color = new int[5];

    public boolean getGraphColor(int m, int n){
        color = new int[n];
        int k = 0;
        while (k >= 0){
            color[k]++;
            while (color[k] <= m){
                if (isOK(k)){
                    break;
                }
                color[k]++;
            }
            if (color[k] <= m && k == n - 1){
                return true;
            }
            if (color[k] <= m && k < n - 1){
                k++;
            }else{
                color[k--] = 0;
            }
        }
        return false;
    }

    private boolean isOK(int k) {
        for (int i = k - 1; i >= 0; i--){
            if (graph[i][k] == 1){
                if (color[i] == color[k])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean graphColor = new GraphColor().getGraphColor(3, 5);
        if (graphColor){
            for (int i = 0; i < color.length; i++) {
                System.out.print(color[i] + " ");
            }
        }
    }


}
