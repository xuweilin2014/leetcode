package xu.union_find.problems;

import java.util.*;

/**
 * 在这一题中使用路径压缩，否则会超时
 */
public class Problem1202 {

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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> rootToIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            if (!rootToIndex.containsKey(root)){
                rootToIndex.put(root, new ArrayList<>());
            }
            rootToIndex.get(root).add(i);
        }

        StringBuilder sb = new StringBuilder(s);
        for (Map.Entry<Integer, List<Integer>> entry : rootToIndex.entrySet()) {
            Integer root = entry.getKey();
            List<Integer> indices = rootToIndex.get(root);

            if (indices.size() == 1)
                continue;

            char[] chs = new char[indices.size()];
            for (int i = 0; i < indices.size(); i++) {
                chs[i] = s.charAt(indices.get(i));
            }
            Arrays.sort(chs);

            for (int i = 0; i < indices.size(); i++) {
                sb.setCharAt(indices.get(i), chs[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);l2.add(2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(0);l3.add(2);
        lists.add(l1);lists.add(l2);/*lists.add(l3);*/
        System.out.println(new Problem1202().smallestStringWithSwaps("dcab", lists));
    }
}
