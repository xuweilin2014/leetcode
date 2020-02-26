package xu.heap;

import java.util.*;

/**
 * 这一题需要使用小根堆结构。基本思想是：如果要求数据流中最大元素，那么只需要维护一个当前最大值，
 * 每次新元素进来，和当前最大值比较即可。那么当题目升级成了求第 K 大元素，那么我们只需要维护最大的k个数，
 * 每次新元素进来，和这最大K个数中最小值比较即可。
 */

class Problem703 {

    private int Kth;
    private int[] vals;

    public Problem703(int k, int[] nums) {
        Kth = k;
        vals = new int[k+1];
        Arrays.fill(vals, Integer.MIN_VALUE);
        int i = 1;
        for (; i <= k && i <= nums.length ; i++) {
            vals[i] = nums[i-1];
        }
        initial();
        while (i <= nums.length){
            add(nums[i-1]);
            i++;
        }
    }

    private void initial() {
        for (int i = Kth / 2; i >= 1; i--) {
            heapAdjust(i, Kth);
        }
    }

    private void heapAdjust(int s, int m) {
        int key = vals[s];
        for (int j = 2 * s; j <= m ; j *= 2) {
            if (j < m && vals[j] > vals[j+1])
                j++;
            if (key < vals[j])
                break;
            vals[s] = vals[j];
            s = j;
        }
        vals[s] = key;
    }

    public int add(int val) {
        if (val > vals[1]){
            vals[1] = val;
            heapAdjust(1, Kth);
        }
        return vals[1];
    }

    public static void main(String[] args) {
        Problem703 ints = new Problem703(1, new int[]{});
        System.out.println(ints.add(-3));
        System.out.println(ints.add(-5));
        System.out.println(ints.add(10));
        System.out.println(ints.add(9));
        System.out.println(ints.add(4));
    }
}
