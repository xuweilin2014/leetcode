package xu.heap;

import java.util.*;

public class Problem347 {

    private List<Integer> ans = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    static class Pair{
        int val;
        int frequency;

        Pair(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }

    static class PairComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.frequency - o2.frequency;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(k+1, new PairComparator());
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        int counter = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (counter <= k){
                queue.add(new Pair(entry.getKey(), entry.getValue()));
            }else{
                if (entry.getValue() > queue.peek().frequency){
                    queue.poll();
                    queue.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
            counter++;

        }

        while (!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem347().topKFrequent(new int[]{1,1,1,1,2,2,2,5,5,7,8,9,4,4
                ,4,4,4,4,4,3,2,2,2,2,7,77,7,77,77,77,77,77,77}, 4));
    }

}
