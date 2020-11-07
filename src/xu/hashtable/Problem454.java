package xu.hashtable;

import xu.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Long, List<Pair>> ansOne = new HashMap<>();
        Map<Long, List<Pair>> ansTwo = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                func(A[i], B[j], ansOne);
                func(C[i], D[j], ansTwo);
            }
        }

        int counter = 0;
        for (Map.Entry<Long, List<Pair>> entry : ansOne.entrySet()) {
            Long key = entry.getKey();
            if (ansTwo.containsKey(-key)){
                counter += (ansOne.get(key).size() * ansTwo.get(-key).size());
            }
        }

        return counter;
    }

    private void func(int val1, int val2, Map<Long, List<Pair>> ans){
        long key = val1 + val2;
        List<Pair> pairs = ans.get(key);
        Pair pair = new Pair(val1, val2);

        if (pairs == null){
            pairs = new ArrayList<>();
            pairs.add(pair);
            ans.put(key, pairs);
        }else {
            pairs.add(pair);
        }
    }

    static class Pair{
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    public static void main(String[] args) {
        System.out.println(new Problem454().fourSumCount(
                new int[]{1, 2},
                new int[]{-2,-1},
                new int[]{-1, 2},
                new int[]{0, 2}));
    }

}
