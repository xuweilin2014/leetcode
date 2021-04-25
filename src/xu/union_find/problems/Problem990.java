package xu.union_find.problems;

import xu.union_find.UnionFind;

import java.util.*;

public class Problem990 {

    static class UnionFind{

        public int[] parents;

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
            for (;parents[v] >= 0;)
                v = parents[v];
            int root = v, lead;
            for (;parents[trail] >= 0; trail = lead){
                lead = parents[trail];
                parents[trail] = lead;
            }

            return root;
        }
    }

    public boolean equationsPossible(String[] equations) {
        List<Character> chs = new ArrayList<>();
        for (String equation : equations) {
            char c1 = equation.charAt(0);
            char c2 = equation.charAt(3);
            if (!chs.contains(c1))
                chs.add(c1);
            if (!chs.contains(c2))
                chs.add(c2);
        }

        UnionFind uf = new UnionFind(chs.size());
        for (String equation : equations) {
            String op = equation.substring(1,3);
            int c1 = chs.indexOf(equation.charAt(0));
            int c2 = chs.indexOf(equation.charAt(3));
            if ("==".equals(op))
                uf.union(c1, c2);
        }

        for (String equation : equations) {
            String op = equation.substring(1,3);
            int c1 = chs.indexOf(equation.charAt(0));
            int c2 = chs.indexOf(equation.charAt(3));
            if ("!=".equals(op))
                if (uf.find(c1) == uf.find(c2))
                    return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem990().equationsPossible(new String[]{
                "a==b","b!=c","c==a"
        }));
    }
}
