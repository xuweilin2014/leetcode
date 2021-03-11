package offer.question1_10.questions;

/**
 * 在一个长度为 n+1 的数组中，所有的数字都在 1~n 范围内，所以数组中肯定有一个数字是重复的。请找出这个数字
 * 方案1：创建一个长度为 n+1 的辅助数组，然后逐一把原数组中的每个数字复制到辅助数组中，如果原数组中的元素的值为 m，那么把它
 * 复制到辅助数组中第 m 个元素上。这样就可以很方便地找出重复元素。
 *
 * 方案2：假设 1~n 的中点为 m，那么把原数组分为两部分：1~m，m+1~n，如果原数组中值在 1~m 这个范围内的元素个数大于 m 个，那么在这一半
 * 的区间中肯定存在重复元素，否则 m+1~n 这个区间中包含重复元素。然后继续把包含重复元素的区间一分为二，直到找到重复元素。
 */
public class Question3_2 {

    public static void main(String[] args) {
        System.out.println(new Question3_2().getDuplication(new int[]{2, 1, 5, 2, 4, 6, 6, 7}));
    }

    public int getDuplication(int[] nums){
        int start = 1;
        int end = nums.length;

        while (start < end){
            int middle = (start + end) / 2;
            int leftCount = rangeCount(start, middle, nums);

            if (leftCount > (middle - start + 1)){
                end = middle;
            }else{
                start = middle + 1;
            }
        }

        return start;
    }

    private int rangeCount(int start, int end, int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end)
                count++;
        }

        return count;
    }

}
