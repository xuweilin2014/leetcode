package now_coder.sort;

import java.util.Arrays;

public class NC140 {

    public int[] MySort (int[] arr) {
        // write code here
        // 冒泡排序
        quickSort(arr, 0, arr.length - 1);

        return arr;
    }

    // 快速排序
    private void quickSort(int[] arr, int left, int right){
        if (left >= right)
            return;

        int low = left;
        int high = right;
        int key = arr[left];

        while (low < high){
            while (low < high && arr[high] >= key)
                high--;

            if (low < high){
                arr[low] = arr[high];
            }

            while (low < high && arr[low] <= key)
                low++;

            if (low < high){
                arr[high] = arr[low];
            }
        }

        arr[low] = key;
        quickSort(arr, left, low - 1);
        quickSort(arr, low + 1, right);
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10, -100, 100);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(new NC140().MySort(array)));
    }
}
