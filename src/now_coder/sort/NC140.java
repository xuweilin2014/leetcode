package now_coder.sort;

import java.util.Arrays;

public class NC140 {

    public int[] MySort (int[] arr) {
        // write code here
        // 堆排序
        heapSort(arr);
        return arr;
    }

    private void heapSort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        for (int i = arr.length / 2; i >= 1; i--) {
            heapAdjust(arr, i, arr.length);
        }

        for (int i = arr.length; i >= 1; i--) {
            int temp = arr[i - 1];
            arr[i - 1] = arr[0];
            arr[0] = temp;
            heapAdjust(arr, 1, i - 1);
        }
    }

    private void heapAdjust(int[] arr, int low, int high){
        int j = low;
        int key = arr[low - 1];

        for (int i = low * 2; i <= high; i = i * 2) {
            if (i + 1 <= high && arr[i - 1] < arr[i])
                i++;
            if (key >= arr[i - 1])
                break;

            arr[j - 1] = arr[i - 1];
            j = i;
        }

        arr[j - 1] = key;
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(7, 0, 100);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(new NC140().MySort(new int[]{32, 62, 4, 61, 56, 18, 70})));
    }
}
