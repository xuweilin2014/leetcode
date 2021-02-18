package xu.backtracking.problems;


public class Problem79 {

    private int[][] visited;
    private boolean existed = false;
    private int rows = 0;
    private int cols = 0;
    private String word;
    private int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;

        this.word = word;
        rows = board.length;
        cols = board[0].length;
        visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)){
                    func(board, 0, i, j);
                }
            }
        }

        return existed;
    }

    private void func(char[][] board, int index, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] == 1)
            return;

        if (existed)
            return;

        if (board[row][col] == word.charAt(index)){
            if (index == word.length() - 1){
                existed = true;
                return;
            }
            for (int[] direction : directions) {
                visited[row][col] = 1;
                func(board, index + 1, row + direction[0], col + direction[1]);
                visited[row][col] = 0;
            }
        }
    }


    public static void main(String[] args) {
        boolean see = new Problem79().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        }, "ABCCED");
        System.out.println(see);

        see = new Problem79().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        }, "SEE");
        System.out.println(see);

        see = new Problem79().exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        }, "ABCB");
        System.out.println(see);
    }

}
