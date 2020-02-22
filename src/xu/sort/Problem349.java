package xu.sort;

import java.util.HashSet;
import java.util.Set;

public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        sort(nums1, 0, nums1.length - 1);
        sort(nums2, 0, nums2.length - 1);
        int slow = 0;
        int high = 0;
        Set<Integer> set = new HashSet<>();
        while (slow < nums1.length && high < nums2.length){
            if (nums1[slow] == nums2[high]) {
                set.add(nums1[slow]);
                slow++;
                high++;
            }
            else if (nums1[slow] > nums2[high])
                high++;
            else
                slow++;
        }
        int[] ans = new int[set.size()];
        int k = 0;
        for (int val : set) {
            ans[k++] = val;
        }
        return ans;
    }

    private void sort(int[] nums, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = nums[begin];
            while (i < j){
                while (i < j && nums[j] > key)
                    j--;
                if (i < j){
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < key)
                    i++;
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = key;
            sort(nums, begin, i - 1);
            sort(nums, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] ints = new Problem349().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
