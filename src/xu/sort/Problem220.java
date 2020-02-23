package xu.sort;

import java.util.*;

public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        List<Integer> indics = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            indics.add(i);
        }
        sort(nums, indics, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length){
                long val1 = nums[i];
                long val2 = nums[j];
                if (Math.abs(val1 - val2) > t)
                    break;

                int index1 = indics.get(i);
                int index2 = indics.get(j);
                if (Math.abs(index1 - index2) > k) {
                    j++;
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    private void sort(int[] vals, List<Integer> indics, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = vals[begin];
            int index = indics.get(begin);
            while (i < j){
                while (i < j && vals[j] < key)
                    j--;
                if (i < j){
                    vals[i] = vals[j];
                    indics.set(i, indics.get(j));
                    i++;
                }
                while (i < j && vals[i] > key)
                    i++;
                if (i < j){
                    vals[j] = vals[i];
                    indics.set(j, indics.get(i));
                    j--;
                }
            }
            vals[i] = key;
            indics.set(i, index);
            sort(vals, indics, begin, i - 1);
            sort(vals, indics, i + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem220()
                .containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
    }
}
