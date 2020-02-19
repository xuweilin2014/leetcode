package xu.graph;

import java.util.*;

public class Problem332 {

    private List<List<String>> ans = new ArrayList<>();
    private Map<String, Integer> cityToId;

    public List<String> findItinerary(List<List<String>> tickets) {
        cityToId = new HashMap<>();
        int id = 0;
        for (List<String> ticket : tickets) {
            for (String city : ticket) {
                if (!cityToId.containsKey(city)){
                    cityToId.put(city, id++);
                }
            }
        }
        List<List<String>> graph = new ArrayList<>(cityToId.size());
        for (int i = 0; i < cityToId.size(); i++) {
            graph.add(new ArrayList<>());
        }
        for (List<String> ticket : tickets) {
            graph.get(cityToId.get(ticket.get(0))).add(ticket.get(1));
        }
        for (List<String> set : graph) {
            Collections.sort(set);
        }
        dfs(new ArrayList<>(), "JFK", graph, tickets.size());
        return ans.get(0);
    }

    private void dfs(List<String> travel, String city, List<List<String>> graph, int counter) {
        if (counter == 0){
            travel.add(city);
            ans.add(new ArrayList<>(travel));
            return;
        }

        travel.add(city);
        List<String> citys = graph.get(cityToId.get(city));
        List<String> cs = new ArrayList<>(citys);
        for (String s : cs) {
            citys.remove(s);
            dfs(travel, s, graph, counter - 1);
            if (ans.size() == 1)
                break;
            citys.add(s);
        }
        travel.remove(travel.size() - 1);
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();

        List<String> l1 = new ArrayList<>();
        l1.add("EZE");
        l1.add("TIA");
        List<String> l2 = new ArrayList<>();
        l2.add("EZE");
        l2.add("HBA");
        List<String> l3 = new ArrayList<>();
        l3.add("AXA");
        l3.add("TIA");
        List<String> l4 = new ArrayList<>();
        l4.add("JFK");
        l4.add("AXA");
        List<String> l5 = new ArrayList<>();
        l5.add("ANU");
        l5.add("JFK");
        List<String> l6 = new ArrayList<>();
        l6.add("ADL");
        l6.add("ANU");
        List<String> l7 = new ArrayList<>();
        l7.add("TIA");
        l7.add("AUA");
        List<String> l8 = new ArrayList<>();
        l8.add("ANU");
        l8.add("AUA");

        List<String> l9 = new ArrayList<>();
        l9.add("ADL");
        l9.add("EZE");
        List<String> l10 = new ArrayList<>();
        l10.add("ADL");
        l10.add("EZE");
        List<String> l11 = new ArrayList<>();
        l11.add("EZE");
        l11.add("ADL");
        List<String> l12 = new ArrayList<>();
        l12.add("AXA");
        l12.add("EZE");
        List<String> l13 = new ArrayList<>();
        l13.add("AUA");
        l13.add("AXA");
        List<String> l14 = new ArrayList<>();
        l14.add("JFK");
        l14.add("AXA");
        List<String> l15 = new ArrayList<>();
        l15.add("AXA");
        l15.add("AUA");
        List<String> l16 = new ArrayList<>();
        l16.add("AUA");
        l16.add("ADL");

        List<String> l17 = new ArrayList<>();
        l17.add("ANU");
        l17.add("EZE");
        List<String> l18 = new ArrayList<>();
        l18.add("TIA");
        l18.add("ADL");
        List<String> l19 = new ArrayList<>();
        l19.add("EZE");
        l19.add("ANU");
        List<String> l20 = new ArrayList<>();
        l20.add("AUA");
        l20.add("ANU");
        accounts.add(l1);
        accounts.add(l2);
        accounts.add(l3);
        accounts.add(l4);
        accounts.add(l5);
        accounts.add(l6);
        accounts.add(l7);
        accounts.add(l8);
        accounts.add(l9);
        accounts.add(l10);
        accounts.add(l11);
        accounts.add(l12);
        accounts.add(l13);
        accounts.add(l14);
        accounts.add(l15);
        accounts.add(l16);
        accounts.add(l17);
        accounts.add(l18);
        accounts.add(l19);
        accounts.add(l20);
        System.out.println(new Problem332().findItinerary(accounts));
    }
}
