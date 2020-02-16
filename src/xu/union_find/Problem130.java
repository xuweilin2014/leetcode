package xu.union_find;

import xu.linkedlist.ListNode;

import java.util.*;

public class Problem130 {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;

        int row = board.length;
        int col = board[0].length;
        UnionFind uf = new UnionFind(row * col);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int base = i * col + j;
                if (board[i][j] == 'X')
                    continue;
                uf.union(base, base);
                if (i - 1 >= 0 && board[i-1][j] == 'O')
                    uf.union(base, base - col);
                if (i + 1 < row && board[i+1][j] == 'O')
                    uf.union(base, base + col);
                if (j - 1 >= 0 && board[i][j-1] == 'O')
                    uf.union(base, base - 1);
                if (j + 1 < col && board[i][j+1] == 'O')
                    uf.union(base, base + 1);
            }
        }

        for (int i = 0; i < uf.parents.length; i++) {
            int root = uf.find(i);
            if (map.containsKey(root)){
                map.get(root).add(i);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(root, set);
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> vals = entry.getValue();
            boolean flag = false;
            for (Integer val : vals) {
                if (val / col == 0 || val / col == board.length - 1) {
                    flag = true;
                    break;
                }
                if (val % col == 0 || val % col == col - 1){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                for (Integer val : vals) {
                    board[val/col][val%col] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] chars = {
                {'O', 'X', 'X', 'O','X'},
                {'X', 'O', 'O', 'X','O'},
                {'X', 'O', 'X', 'O','X'},
                {'O', 'X', 'O', 'O','X'},
                {'X', 'X', 'X', 'X','X'}
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
