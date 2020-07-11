package algorithm_analysis_and_design.divide_and_conquer;

/**
 * 使用分治法解决棋盘覆盖问题
 */
public class ChessBoard {

    private static int[][] chessBoard;

    private static int counter = 0;

    public static void main(String[] args) {
        chessBoard = new int[8][8];
        chessBoardCover(0,0, chessBoard.length, 0, 1);

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                System.out.printf("%2d ", chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void chessBoardCover(int tr, int tc, int size, int dr, int dc){
        if (size == 1)
            return;

        int s = size / 2;
        int domino = ++counter;

        if (dr < tr + s && dc < tc + s)
            chessBoardCover(tr, tc, s, dr, dc);
        else {
            chessBoard[tr+s-1][tc+s-1] = domino;
            chessBoardCover(tr, tc, s, tr + s -1, tc + s - 1);
        }

        if (dr < tr + s && dc >= tc + s)
            chessBoardCover(tr, tc + s, s, dr, dc);
        else{
            chessBoard[tr+s-1][tc+s] = domino;
            chessBoardCover(tr, tc + s, s, tr + s - 1, tc + s);
        }

        if (dr >= tr + s && dc < tc + s)
            chessBoardCover(tr + s, tc, s, dr, dc);
        else{
            chessBoard[tr+s][tc+s-1] = domino;
            chessBoardCover(tr + s, tc, s, tr+s, tc+s-1);
        }

        if (dr >= tr + s && dc >= tc + s)
            chessBoardCover(tr + s, tc + s, s, dr, dc);
        else{
            chessBoard[tr+s][tc+s] = domino;
            chessBoardCover(tr + s, tc + s, s, tr + s, tc + s);
        }

    }

}
