package offer.question31_40.questions;

import java.util.Arrays;

public class Question40 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question40().getLeastNumbers(new int[]{0,0,2,3,2,1,1,2,0,4}, 1)));
        System.out.println(Arrays.toString(new Question40().getLeastNumbers(new int[]{0,0,2,3,2,1,1,2,0,4}, 10)));
    }

    // 使用快排的思想
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr == null || arr.length == 0)
            return new int[]{};

        func(arr, 0, arr.length - 1, k);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    private void func(int[] arr, int left, int right, int k) {
        if (left > right)
            return;

        int low = left;
        int high = right;
        int key = arr[low];
        while (low < high){
            while (low < high && arr[high] > key)
                high--;

            if (low < high){
                arr[low] = arr[high];
                low++;
            }

            while (low < high && arr[low] < key)
                low++;

            if (low < high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = key;

        if (low > k)
            func(arr, left, low - 1, k);
        if (low < k)
            func(arr, low + 1, right, k);
    }


}
