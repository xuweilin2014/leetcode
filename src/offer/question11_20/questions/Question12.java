package offer.question11_20.questions;

public class Question12 {

    private boolean[][] visited;
    private int rows;
    private int cols;
    private int[] dx = new int[]{1,-1,0,0};
    private int[] dy = new int[]{0,0,1,-1};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;

        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (func(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean func(char[][] board, String word, int row, int col, int index) {
        if (index == word.length())
            return true;

        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visited[row][col] || board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;
        for (int i = 0; i < dx.length; i++) {
            int r = row + dx[i];
            int c = col + dy[i];

            if (func(board, word, r, c, index + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Question12().exist(new char[][]{
                {'C','A','A'},
                {'A','A','B'},
                {'B','C','D'}
        }, "AAB"));

        System.out.println(new Question12().exist(new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        }, "AAB"));
    }

}
