package offer.Question61_68.solutions;

import java.util.Arrays;

public class QSolution61 {

    /*
     * 扑克牌中的顺子
     *
     * 统计扑克牌顺子，并且将大小王看成 0。
     * 首先对数组进行排序，统计 0 的个数 zeros 以及空缺的个数，如果空缺的总数小于等于 0 的个数，那么就是顺子。
     * 这里举个例子说明如何统计空缺的个数，比如两个相邻的数：1和 2，那么空缺数 span = 0；而对于 1 和 5 这两个数，空缺数 span = 3，
     * 最后当 zeros >= span 时，那么就表示或者没有空缺，或者空缺都可以被 0 弥补，所以是顺子
     */

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int[] vals = new int[14];
        for (int num : nums) {
            vals[num]++;
        }

        int span = 0;
        int zeros = 0;
        int lastI = 0;

        for (int i = 0; i < vals.length; i++) {
            if (i == 0) {
                zeros += vals[i];
            } else if (vals[i] > 1){
                return false;
            } else if (vals[i] > 0){
                if (lastI != 0){
                    span += (i - lastI - 1);
                }
                lastI = i;
            }
        }

        return span <= zeros;
    }

}
