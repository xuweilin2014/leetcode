package xu.union_find;

import java.util.*;

public class Problem947 {

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(20000);
        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10000);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(uf.find(stone[0]));
        }
        return stones.length - set.size();
    }

    public static void main(String[] args) {
        System.out.println(new Problem947().removeStones(new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        }));
    }
}
