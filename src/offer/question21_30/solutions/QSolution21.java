package offer.question21_30.solutions;

public class QSolution21 {

    /*
     * 调整数组顺序使奇数位于偶数前面
     *
     * 首先，这道题目可能有两个要求，
     *
     * 1.调整数组顺序之后，相对于调整之前，顺序可以发生变化，这样就可以使用快速排序的思想，也就是两个指针分别指向数组的两端 low 和 high，分别表示奇数和偶数。
     * 2.调整数组顺序之后，相对于调整之前，顺序不能发生变化，这样可以使用插入排序的思想，即碰到一个 nums[i] 为奇数，那么就将这个奇数往前
     * 遍历，即往 [0, i-1] 遍历，如果遍历到的是偶数的话，就插入，如果碰到一个奇数，那么就直接退出（因为奇数可以说明是排好序的）。
     *
     */

    // 保持数字之间的相对位置，使用类似于插入排序的方法
    public int[] reOrderArray (int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != 0){
                int val = nums[i];
                int j = i - 1;
                for (; j >= 0; j--) {
                    if (nums[j] % 2 == 0){
                        nums[j + 1] = nums[j];
                    }else {
                        break;
                    }
                }

                nums[j + 1] = val;
            }
        }

        return nums;
    }

}
