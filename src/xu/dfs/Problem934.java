package xu.dfs;

import xu.union_find.UnionFind;
import java.util.ArrayList;
import java.util.List;

/**
 * 此题最短的桥，基本思想是要先发现两座桥，然后再求出两座桥之间的最短距离。具体方法如下：
 * 1.可以使用DFS来发现桥，然后使用BFS来扩展，进而求出桥之间的最短距离（更快)
 * 2.我使用的方法是并查集来发现两座桥上的点保存到两个集合中，然后使用双重循环求出两座桥之间
 *  最短的曼哈顿距离，即桥之间的最短距离
 */

public class Problem934 {

    public int shortestBridge(int[][] A) {
        UnionFind uf = new UnionFind(A.length * A[0].length);
        int row = A.length;
        int col = A[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    int base = i * col + j;
                    if (i + 1 < row && A[i+1][j] == 1)
                        uf.union(base, base + col);
                    if (j + 1 < col && A[i][j+1] == 1)
                        uf.union(base, base + 1);
                }
            }
        }

        List<int[]> v1 = new ArrayList<>();
        List<int[]> v2 = new ArrayList<>();
        int root1 = -1;
        for (int i = 0; i < uf.parents.length; i++) {
            if (A[i/col][i%col] == 1){
                if (v1.isEmpty()){
                    v1.add(new int[]{i/col, i%col});
                    root1 = uf.find(i);
                }else{
                    if (root1 == uf.find(i))
                        v1.add(new int[]{i/col, i%col});
                    else
                        v2.add(new int[]{i/col, i%col});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int[] v : v1) {
            for (int[] w : v2) {
                if (min > Math.abs(v[0]-w[0]) + Math.abs(v[1]-w[1])){
                    min = Math.abs(v[0]-w[0]) + Math.abs(v[1]-w[1]);
                }
            }
        }
        return min - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem934().shortestBridge(new int[][]{
                {0,0,0,0,0,0},
                {0,1,0,0,0,0},
                {1,1,0,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,0,0}
        }));
    }
}
