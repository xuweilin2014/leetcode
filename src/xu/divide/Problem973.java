package xu.divide;

import java.util.*;

public class Problem973 {

    public int[][] kClosest(int[][] points, int K) {
        if (K >= points.length)
            return points;

        Map<Long, List<Integer>> map = new HashMap<>();
        long[] vals = new long[points.length];
        int[][] ans = new int[K][2];

        for (int i = 0; i < points.length; i++) {
            vals[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            List<Integer> list = map.get(vals[i]);
            if (list == null)
                list = new ArrayList<>();
            list.add(i);
            map.put(vals[i], list);
        }

        func(vals,0, vals.length - 1, K);
        int counter = 0;
        for (int i = 0; i < K; i++) {
            if (counter < ans.length)
                for (Integer index : map.get(vals[i])) {
                    ans[counter++] = points[index];
                }
        }

        return ans;
    }

    private void func(long[] vals, int left, int right, int k) {
        if (left >= right)
            return;

        long pivotal = vals[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && vals[high] >= pivotal)
                high--;

            if (low < high)
                vals[low] = vals[high];

            while (low < high && vals[low] <= pivotal)
                low++;

            if (low < high)
                vals[high] = vals[low];
        }

        vals[low] = pivotal;
        if (low > k - 1)
            func(vals, left, low - 1, k);
        else if (low < k - 1)
            func(vals,low + 1, right,  k);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Problem973().kClosest(new int[][]{
                {1,3},{2,-2},{-2,2}
        }, 2)));

        System.out.println(Arrays.deepToString(new Problem973().kClosest(new int[][]{
                {1,3},{2,-2}
        }, 1)));
    }


}
