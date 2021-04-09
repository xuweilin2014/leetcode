package offer.question21_30.questions;

import java.util.Arrays;

public class Question21 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(new Question21().reOrderArray(arr)));

        arr = new int[]{2,4,6,1,3,5};
        System.out.println(Arrays.toString(new Question21().reOrderArray(arr)));

        arr = new int[]{1,3,5,2,4,6};
        System.out.println(Arrays.toString(new Question21().reOrderArray(arr)));

        arr = new int[]{1,3,5};
        System.out.println(Arrays.toString(new Question21().reOrderArray(arr)));
    }

    // 不保持数字之间的相对位置，使用快速排序的思想
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int low;
        for (low = 0;  low < nums.length; low++) {
            if (nums[low] % 2 == 0)
                break;
        }

        if (low == nums.length)
            return nums;

        int pivot = nums[low];
        int high = nums.length - 1;
        while (low < high){
            while (low < high && nums[high] % 2 == 0)
                high--;
            if (low < high){
                nums[low] = nums[high];
            }
            while (low < high && nums[low] % 2 != 0)
                low++;
            if (low < high){
                nums[high] = nums[low];
            }
        }

        nums[low] = pivot;

        return nums;
    }

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
