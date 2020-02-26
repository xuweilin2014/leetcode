package xu.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem451 {
    
    private Map<Character, Integer> map = new HashMap<>();

    static class Pair{
        char val;
        int frequency;

        public Pair(char val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }

    static class CharComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            return -(o1.frequency - o2.frequency);
        }
    }

    public String frequencySort(String s) {
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(new CharComparator());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int i = 0; i < pair.frequency; i++) {
                sb.append(pair.val);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem451().frequencySort("Aabb"));
    }
}
