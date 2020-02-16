package xu.union_find;

import java.util.*;

/**
 * 在这一题中使用路径压缩，否则会超时
 */
public class Problem1202 {

    private int[] parents;

    public int find(int vert){
        int trail = vert;
        while (parents[vert] != vert){
            vert = parents[vert];
        }
        int root = vert;
        int lead;
        for (int v = trail; v != root; v = lead){
            lead = parents[v];
            parents[v] = root;
        }
        return root;
    }

    public void union(int i, int j){
        parents[find(j)] = find(i);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parents = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parents[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        StringBuilder sb = new StringBuilder(s);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            int root = find(i);
            if (map.containsKey(root)){
                map.get(root).add(i);
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(root, tmp);
            }
        }

        for (List<Integer> integers : map.values()) {
            if (integers.size() == 1)
                continue;
            char[] chs = new char[integers.size()];
            for (int i = 0; i < integers.size(); i++) {
                chs[i] = sb.charAt(integers.get(i));
            }
            Arrays.sort(chs);
            for (int i = 0; i < integers.size(); i++) {
                sb.setCharAt(integers.get(i), chs[i]);
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
        lists.add(l1);lists.add(l2);/*lists.add(l3)*/;
        System.out.println(new Problem1202().smallestStringWithSwaps("dcaba", lists));
    }
}
