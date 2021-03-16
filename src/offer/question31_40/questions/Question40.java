package offer.question31_40.questions;

import java.util.Arrays;

public class Question40 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question40().getLeastNumbers(new int[]{0,0,2,3,2,1,1,2,0,4}, 10)));
    }

    // 使用快排的思想
    public static int[] getLeastNumbers(int[] input, int k) {
        k = Math.min(k, input.length);
        int[] vals = new int[k];
        partition(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++) {
            vals[i] = input[i];
        }
        return vals;
    }

    private static void partition(int[] arr, int left, int right, int k){
        if (left >= right)
            return;

        int val = arr[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && arr[high] >= val)
                high--;
            if (low < high)
                arr[low] = arr[high];

            while (low < high && arr[low] <= val)
                low++;
            if (low < high)
                arr[high] = arr[low];
        }

        arr[high] = val;
        if (high == k) {
        }
        else if (high < k){
            partition(arr, high + 1, right, k);
        }else{
            partition(arr, left, high - 1, k);
        }
    }

    // 使用最大堆的思想
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k >= arr.length){
            return arr;
        }

        int[] res = Arrays.copyOfRange(arr, 0, k);
        for (int i = res.length / 2 - 1; i >= 0; i--) {
            adjustHeap(res, i, k - 1);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < res[0]){
                res[0] = arr[i];
                adjustHeap(res, 0, k - 1);
            }
        }

        return res;
    }

    public void adjustHeap(int[] arr, int i, int length){
        int val = arr[i];
        for (int j = 2 * i + 1; j <= length ; j = 2 * j + 1) {
            if (j < length && arr[j] < arr[j + 1])
                j++;
            if (arr[j] < val)
                break;
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = val;
    }

}
