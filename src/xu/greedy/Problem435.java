package xu.greedy;

import xu.hashtable.Problem438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 贪心算法经典题目
// 1.从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
// 2.把所有与 x 区间相交的区间从区间集合 intvs 中删除。
// 3.重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
public class Problem435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });

        int counter = 1;
        int[] tmp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= tmp[1]){
                counter++;
                tmp = intervals[i];
            }
        }

        return intervals.length - counter;
    }

    private void sort(int[][] intervals){
        if (intervals == null || intervals.length == 0)
            return;

        func(intervals,0, intervals.length - 1);
    }

    private void func(int[][] ints, int left, int right){
        if (left >= right)
            return;

        int[] key = ints[left];
        int low = left;
        int high = right;

        while (low < high){
            while (low < high && ints[high][1] > key[1])
                high--;
            if (low < high){
                ints[low] = ints[high];
                low++;
            }
            while (low < high && ints[low][1] < key[1])
                low++;
            if (low < high) {
                ints[high] = ints[low];
                high--;
            }
        }

        ints[high] = key;

        func(ints, left, high - 1);
        func(ints, high + 1, right);
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{
                {1,2},{2,3},{3,4},{2,5},{6,7},{3,8},{2,6}
        };
        System.out.println(new Problem435().eraseOverlapIntervals(res));
    }

}
