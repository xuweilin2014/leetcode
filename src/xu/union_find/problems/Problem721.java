package xu.union_find.problems;

import xu.union_find.UnionFind;

import java.util.*;

public class Problem721 {

    static class UnionFind{

        protected int[] parents;

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
            for (; parents[trail] >= 0; trail = lead){
                lead = parents[trail];
                parents[trail] = root;
            }

            return root;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int counter = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToName.containsKey(email) && !emailToIndex.containsKey(email)){
                    emailToIndex.put(email, counter++);
                    emailToName.put(email, name);
                }
            }
        }

        UnionFind uf = new UnionFind(emailToIndex.size());
        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                String email1 = account.get(i);
                String email2 = account.get(i - 1);
                uf.union(emailToIndex.get(email1), emailToIndex.get(email2));
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (Map.Entry<String, String> entry : emailToName.entrySet()) {
            String email = entry.getKey();
            int root = uf.find(emailToIndex.get(email));
            if (!indexToEmails.containsKey(root)){
                indexToEmails.put(root, new ArrayList<>());
            }
            if (!indexToEmails.get(root).contains(email))
                indexToEmails.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> es : indexToEmails.values()) {
            Collections.sort(es);
            String name = emailToName.get(es.get(0));
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(es);
            ans.add(list);
        }

        return ans;
    }


    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("John");
        l1.add("johnsmith@mail.com");
        l1.add("john00@mail.com");
        List<String> l2 = new ArrayList<>();
        l2.add("John");
        l2.add("johnnybravo@mail.com");
        List<String> l3 = new ArrayList<>();
        l3.add("John");
        l3.add("johnsmith@mail.com");
        l3.add("john_newyork@mail.com");
        List<String> l4 = new ArrayList<>();
        l4.add("Mary");
        l4.add("mary@mail.com");
        accounts.add(l1);
        accounts.add(l2);
        accounts.add(l3);
        accounts.add(l4);
        System.out.println(new Problem721().accountsMerge(accounts));
    }
}
