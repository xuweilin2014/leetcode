package xu.dfs.problems;

import xu.union_find.UnionFind;

import java.util.*;

/**
 * 飞地的数量，可以使用并查集或者DFS来进行解决。使用DFS的时候，可以将每个遍历过的每个顶点
 * 值改为0，来防止对一个顶点的重复访问
 */

public class Problem1020 {

    private int counter = 0;
    private int rows, cols;
    private boolean flag = true;
    private int sum = 0;

    public int numEnclaves(int[][] A) {
        if (A.length == 0)
            return 0;

        rows = A.length;
        cols = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sum = 0;
                flag = false;
                if (A[i][j] == 1) {
                    sum = 0;
                    flag = false;
                    dfs(A, i, j);
                }
                if (!flag)
                    counter += sum;
            }
        }

        return counter;
    }

    private void dfs(int[][] graph, int row, int col) {
        if (row < 0 || row > rows - 1 || col < 0
                || col > cols - 1 || graph[row][col] == 0)
            return;

        if (row == 0 || row == rows - 1 || col == 0
                || col == cols - 1){
            flag = true;
            return;
        }

        graph[row][col] = 0;
        sum++;
        dfs(graph, row + 1, col);
        dfs(graph, row - 1, col);
        dfs(graph, row, col + 1);
        dfs(graph, row, col - 1);
    }

    public int solution1(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int zeroCounter = 0;
        UnionFind uf = new UnionFind(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 0) {
                    zeroCounter++;
                    continue;
                }
                int base = i * col + j;
                if (i + 1 < row && A[i+1][j] == 1)
                    uf.union(base, base + col);
                if (j + 1 < col && A[i][j+1] == 1)
                    uf.union(base, base + 1);
            }
        }

        int ans = 0;
        Set<Integer> edges = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < uf.parents.length; i++) {
            if (A[i/col][i%col] == 0)
                continue;
            if (i % col == 0 || i / col == 0 ||
                    i % col == col - 1 || i / col == row - 1){
                    edges.add(uf.find(i));
            }
            int root = uf.find(i);
            if (map.containsKey(root)){
                map.get(root).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(root, list);
            }
        }

        for (Integer edge : edges) {
            map.remove(edge);
        }

        int sum = 0;
        for (List<Integer> value : map.values()) {
            sum += value.size();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1020().numEnclaves(new int[][]{
                {1, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        }));
    }
}
