package xu.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem373 {

    static class Pair{
        int val1;
        int val2;

        public Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    static class PairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            return (o1.val1 + o1.val2) - (o2.val1 + o2.val2);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new PairComparator());
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.add(new Pair(nums1[i], nums2[j]));
            }
        }
        int counter = 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty() && counter <= k) {
                Pair pair = queue.poll();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(pair.val1);
                tmp.add(pair.val2);
                ans.add(tmp);
                counter++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem373().kSmallestPairs(new int[]{1,2,4,5,6},
                new int[]{3,5,7,9}, 3));
    }
}
