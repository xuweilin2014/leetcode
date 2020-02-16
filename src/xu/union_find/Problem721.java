package xu.union_find;

import java.util.*;

public class Problem721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(12000);
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if ("".equals(name)){
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)){
                    emailToId.put(email, id++);
                }
                uf.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int root = uf.find(emailToId.get(email));
            if (map.containsKey(root)){
                map.get(root).add(email);
            }else{
                List<String> list = new ArrayList<>();
                list.add(email);
                map.put(root, list);
            }
        }

        for (List<String> entry : map.values()) {
            Collections.sort(entry);
            entry.add(0, emailToName.get(entry.get(0)));
        }

        return new ArrayList<>(map.values());
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
