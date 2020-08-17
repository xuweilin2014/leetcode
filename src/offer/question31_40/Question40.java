package offer.question31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question40 {

    public static void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3}, 8));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> lists = new ArrayList<>();
        if (k == input.length){
            for (int i = 0; i < input.length; i++) {
                lists.add(input[i]);
            }
            return lists;
        }else if (k > input.length)
            return lists;

        int vals = getKthIntegers(input, k, 0, input.length - 1);
        for (int i = 0; i < vals; i++) {
            lists.add(input[i]);
        }

        return lists;
    }

    public static int getKthIntegers(int[] arr, int k, int left, int right){
        int val = arr[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && val <= arr[high]){
                high--;
            }

            if (low < high)
                arr[low] = arr[high];

            while (low < high && val >= arr[low]){
                low++;
            }

            if (low < high)
                arr[high] = arr[low];
        }

        arr[high] = val;

        if (k == high)
            return high;
        else if (k > high)
            return getKthIntegers(arr, k, left + 1, right);
        else
            return getKthIntegers(arr, k, left, right - 1);
    }

}
