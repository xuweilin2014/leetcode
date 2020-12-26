package xu.dp.problems;

import xu.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 最长等差数列
public class Problem1027 {

    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        if (A.length == 1)
            return 1;

        List<Map<Integer, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            dp.add(new HashMap<>());
        }
        int maxLen = 2;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int interval = A[i] - A[j];
                if (dp.get(j).containsKey(interval)){
                    Integer tmp = dp.get(j).get(interval);
                    dp.get(i).put(interval, Math.max(2, tmp + 1));
                    maxLen = Math.max(dp.get(i).get(interval), maxLen);
                }else {
                    dp.get(i).put(interval, 2);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1027().longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(new Problem1027().longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(new Problem1027().longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }

}
