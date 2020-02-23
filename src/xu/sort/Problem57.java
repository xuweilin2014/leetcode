package xu.sort;

import java.util.*;

public class Problem57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> interval = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int key = intervals[i][0];
            if (interval.containsKey(key)){
                if (interval.get(key) < intervals[i][1])
                    interval.put(key, intervals[i][1]);
            }else
                interval.put(intervals[i][0], intervals[i][1]);
            list.add(intervals[i][0]);
        }

        list.add(newInterval[0]);
        if (interval.containsKey(newInterval[0])){
            if (interval.get(newInterval[0]) < newInterval[1])
                interval.put(newInterval[0], newInterval[1]);
        }else
            interval.put(newInterval[0], newInterval[1]);
        Collections.sort(list);
        List<int[]> ans = new ArrayList<>();
        int[] visited = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (visited[i] == 1)
                continue;

            visited[i] = 1;
            int left = list.get(i);
            int right = interval.get(left);
            int k = i + 1;
            while (k < list.size() && list.get(k) <= right){
                if (interval.get(list.get(k)) > right)
                    right = interval.get(list.get(k));
                visited[k] = 1;
                k++;
            }
            ans.add(new int[]{left, right});
        }

        int[][] vals = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            vals[i][0] = ans.get(i)[0];
            vals[i][1] = ans.get(i)[1];
        }
        return vals;
    }

    public static void main(String[] args) {
        int[][] ints = new Problem57().insert(new int[][]{
                {1, 5}
        }, new int[]{1, 7});
        for (int i = 0; i < ints.length; i++) {
            System.out.print("[" + ints[i][0] + ", " + ints[i][1] + "] ");
        }
    }
}
