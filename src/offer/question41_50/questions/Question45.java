package offer.question41_50.questions;

import java.util.ArrayList;
import java.util.List;

public class Question45 {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] sbs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sbs[i] = String.valueOf(nums[i]);
        }

        func(sbs, 0, sbs.length - 1);

        StringBuilder ans = new StringBuilder();
        for (String sb : sbs) {
            ans.append(sb);
        }

        return ans.toString();
    }

    private void func(String[] sbs, int left, int right) {
        if (left >= right)
            return;

        int low = left;
        int high = right;
        String key = sbs[low];
        while (low < high){
            while (low < high && comp(sbs[high], key) > 0)
                high--;

            if (low < high){
                sbs[low] = sbs[high];
                low++;
            }

            while (low < high && comp(sbs[low], key) < 0)
                low++;

            if (low < high){
                sbs[high] = sbs[low];
                high--;
            }
        }

        sbs[low] = key;
        func(sbs, left, low - 1);
        func(sbs, low + 1, right);
    }

    private long comp(String sb, String key) {
        return Long.parseLong(sb + key) - Long.parseLong(key + sb);
    }

    public static void main(String[] args) {
        System.out.println(new Question45().minNumber(new int[]{1,2,3,1}));
        System.out.println(new Question45().minNumber(new int[]{3,30,34,5,9}));
        System.out.println(new Question45().minNumber(new int[]{999999998,999999997,999999999}));
    }

}
