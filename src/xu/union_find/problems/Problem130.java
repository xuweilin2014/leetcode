package xu.union_find.problems;


import java.util.*;

public class Problem130 {

    static class UnionFind{

        private int[] parents;

        public UnionFind(int len){
            parents = new int[len];
            Arrays.fill(parents, -1);
        }

        public void union(int i, int j){
            int r1 = find(i);
            int r2 = find(j);
            if (r1 != r2)
                parents[r1] = r2;
        }

        public int find(int v){
            int trail = v;
            for (; parents[v] >= 0; )
                v = parents[v];

            int root = v, lead;
            for (; parents[trail] >= 0; trail = lead){
                lead = parents[trail];
                parents[trail] = root;
            }

            return root;
        }

    }

    private int rows;
    private int cols;

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        rows = board.length;
        cols = board[0].length;
        UnionFind uf = new UnionFind(rows * cols + 1);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O'){
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1){
                        uf.union(node(i, j), rows * cols);
                    }else {
                        if (board[i - 1][j] == 'O'){
                            uf.union(node(i, j), node(i - 1, j));
                        }
                        if (i + 1 < rows && board[i + 1][j] == 'O'){
                            uf.union(node(i + 1, j), node(i, j));
                        }
                        if (board[i][j - 1] == 'O'){
                            uf.union(node(i, j - 1), node(i, j));
                        }
                        if (j + 1 < cols && board[i][j + 1] == 'O'){
                            uf.union(node(i, j + 1), node(i, j));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               if (board[i][j] == 'O'){
                   if (uf.find(node(i, j)) != uf.find(rows * cols)){
                       board[i][j] = 'X';
                   }
               }
            }
        }
    }

    private int node(int i, int j){
        return i * cols + j;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'X', 'O', 'X','X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}
        };
        new Problem130().solve(chars);
        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[0].length; k++) {
                System.out.print(chars[i][k] + " ");
            }
            System.out.println();
        }
    }

}
