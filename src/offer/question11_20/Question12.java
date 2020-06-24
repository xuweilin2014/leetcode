package offer.question11_20;

public class Question12 {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    if (doSearch(board, i, j, words, 0))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean doSearch(char[][] board, int row, int col, char[] words, int k) {
        if (row >= board.length || row < 0 || col < 0 || col >= board[0].length || board[row][col] != words[k]){
            return false;
        }

        if (k == words.length - 1)
            return true;

        char tmp = board[row][col];
        board[row][col] = '/';
        boolean result = doSearch(board, row + 1, col, words, k + 1)
                || doSearch(board, row, col + 1, words, k + 1)
                || doSearch(board, row - 1, col, words, k + 1)
                || doSearch(board, row, col - 1, words, k + 1);
        board[row][col] = tmp;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Question12().exist(new char[][]{
                {'C','A','A'},
                {'A','A','B'},
                {'B','C','D'}
        }, "AAB"));
    }

}
