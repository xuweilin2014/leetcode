package xu.union_find;

public class Problem200 {

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(row * col);
        int zeroCounter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int base = i * col + j;
                if (grid[i][j] == '0') {
                    zeroCounter++;
                    continue;
                }
                if (i - 1 >= 0 && grid[i-1][j] == '1')
                    uf.union(base, base - col);
                if (i + 1 < row && grid[i+1][j] == '1')
                    uf.union(base, base + col);
                if (j - 1 >= 0 && grid[i][j-1] == '1')
                    uf.union(base, base - 1);
                if (j + 1 < col && grid[i][j+1] == '1')
                    uf.union(base, base + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < uf.parents.length; i++) {
            if (uf.parents[i] == i)
                ans++;
        }
        return ans - zeroCounter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem200().numIslands(new char[][]{
                {'1'},{'1'}
        }));
    }

}
