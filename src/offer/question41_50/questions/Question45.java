package offer.question41_50.questions;

import java.util.ArrayList;
import java.util.List;

public class Question45 {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        func(numbers, 0, numbers.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }

        return sb.toString();
    }

    private void func(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivot = nums[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && comp(nums[high], pivot) > 0)
                high--;
            if (low < high){
                nums[low] = nums[high];
                low++;
            }
            while (low < high && comp(nums[low], pivot) < 0)
                low++;
            if (low < high){
                nums[high] = nums[low];
                high--;
            }
        }

        nums[low] = pivot;
        func(nums, left, low - 1);
        func(nums, low + 1, right);
    }

    private int comp(int val1, int val2){
        long d1 = Long.parseLong(val1 + String.valueOf(val2));
        long d2 = Long.parseLong(val2 + String.valueOf(val1));
        return (int) (d1 - d2);
    }


    public static void main(String[] args) {
        System.out.println(new Question45().PrintMinNumber(new int[]{1,2,3,1}));
        System.out.println(new Question45().PrintMinNumber(new int[]{3,30,34,5,9}));
        System.out.println(new Question45().PrintMinNumber(new int[]{999999998,999999997,999999999}));
    }

}
