package xu.backtracking;


public class Problem79 {

    private int[][] visited;
    private String word;
    private int rows, cols;
    private boolean flag = false;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        visited = new int[rows][cols];
        char first = word.charAt(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == first){
                    dfs(board, "", i, j, 0);
                    if (flag)
                        return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String path, int row, int col, int index) {
        if (path.length() == word.length()){
            flag = true;
            return;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col] == 1 || path.length() > word.length())
            return;

        path += board[row][col];
        if (path.charAt(index) != word.charAt(index))
            return;

        if (!flag){
            visited[row][col] = 1;
            dfs(board, path, row, col + 1, index + 1);
            dfs(board, path, row + 1, col, index + 1);
            dfs(board, path, row, col - 1,  index + 1);
            dfs(board, path, row - 1, col, index + 1);
            visited[row][col] = 0;
        }
    }

    public static void main(String[] args) {
        boolean see = new Problem79().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        }, "ABCCED");
        System.out.println(see);
    }

}
