package xu.dfs;

public class Problem733 {

    private int[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new int[image.length][image[0].length];
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
                || visited[sr][sc] == 1 || image[sr][sc] != color)
            return;

        visited[sr][sc] = 1;
        if (image[sr][sc] == color)
            image[sr][sc] = newColor;

        dfs(image, sr + 1, sc, newColor, color);
        dfs(image, sr - 1, sc, newColor, color);
        dfs(image, sr, sc + 1, newColor, color);
        dfs(image, sr, sc - 1, newColor, color);
    }

    public static void main(String[] args) {
        int[][] ints = new Problem733().floodFill(new int[][]{
                {0, 0, 0}, {0, 0, 1},{1,1,0}
        }, 2, 0, 0);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
