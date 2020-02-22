package xu.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        sort(nums1, 0, nums1.length - 1);
        sort(nums2, 0, nums2.length - 1);
        int slow = 0;
        int high = 0;
        List<Integer> set = new ArrayList<>();
        while (slow < nums1.length && high < nums2.length){
            if (nums1[slow] == nums2[high]) {
                set.add(nums1[slow]);
                slow++;
                high++;
            }
            else if (nums1[slow] < nums2[high])
                slow++;
            else
                high++;
        }
        int[] ans = new int[set.size()];
        int k = 0;
        for (int val : set) {
            ans[k++] = val;
        }
        return ans;
    }

    private void sort(int[] arr, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = arr[begin];
            while (i < j){
                while (i < j && arr[j] > key)
                    j--;
                if (i < j){
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < key)
                    i++;
                if (i < j){
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = key;
            sort(arr, begin, i - 1);
            sort(arr, i + 1,  end);
        }
    }

    public static void main(String[] args) {
        int[] ints = new Problem350().intersect(new int[]{3, 4, 5, 9}, new int[]{4, 8, 9, 9});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
