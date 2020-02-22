package xu.sort;

import java.util.*;

public class Problem56 {
    public int[][] merge(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> interval = new HashMap<>();
        int[] visited = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int key = intervals[i][0];
            if (interval.containsKey(key)){
                if (interval.get(key) < intervals[i][1])
                    interval.put(key, intervals[i][1]);
            }else
                interval.put(intervals[i][0], intervals[i][1]);
            list.add(intervals[i][0]);
        }
        Collections.sort(list);
        List<int[]> ans = new ArrayList<>();

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

    public void sort(List<Integer> arr, int begin, int end){
        if (begin < end){
            int i = begin;
            int j = end;
            int key = arr.get(begin);
            while (i < j){
                while (i < j && arr.get(j) > key)
                    j--;
                if (i < j){
                    arr.set(i, arr.get(j));
                    i++;
                }
                while (i < j && arr.get(i) < key)
                    i++;
                if (i < j){
                    arr.set(j, arr.get(i));
                    j--;
                }
            }
            arr.set(i, key);
            sort(arr, begin,  i - 1);
            sort(arr, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[][] ints = new Problem56().merge(new int[][]{
                {2, 3}, {5, 5}, {2, 2}, {3, 4},{3, 4}
        });
        for (int i = 0; i < ints.length; i++) {
            System.out.print("[" + ints[i][0] + ", " + ints[i][1] + "] ");
        }
    }
}
