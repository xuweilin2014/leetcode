package offer.Question51_60.solutions;

import java.util.ArrayList;
import java.util.List;

public class QSolution57_2 {

    /*
     * 和为 S 的连续正数序列
     *
     * 使用滑动窗口来解决这道题目：
     *
     * 1.当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
     * 2.当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
     * 3.当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)，那么我们已经找到了一个 ii 开头的序列，
     * 也是唯一一个 ii 开头的序列，接下来需要找 i+1 开头的序列，所以窗口的左边界要向右移动。这里注意，这里既可以左边界右移，也可以
     * 右边界右移
     */

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if (sum == 0)
            return new ArrayList<>();

        int low = 1;
        int high = 2;
        int win = 3;
        ArrayList<Integer[]> arr = new ArrayList<>();
        while (low < sum){
            if (win < sum) {
                high++;
                win = win + high;
            }else if (win == sum){
                arr.add(new Integer[]{low, high});
                low++;
                win = win - (low - 1);
            }else {
                low++;
                win = win - (low - 1);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (Integer[] vals : arr) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = vals[0]; i <= vals[1]; i++) {
                tmp.add(i);
            }
            ans.add(tmp);
        }

        return ans;
    }


}
