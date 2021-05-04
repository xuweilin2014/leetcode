package now_coder.sort;

public class NCSolution140 {

    /*
     * 排序
     *
     * 在这题中，我们实现几个常用的排序算法：
     *
     * 1.冒泡排序
     * 2.快速排序
     * 3.堆排序
     * 4.归并排序
     * 5.选择排序
     * 6.插入排序
     */

    // 冒泡排序
    private void bubbleSort(int[] arr){
        /*
         * 冒泡排序步骤如下：
         * 1.每次都从 arr[0] 开始，依次比较 arr[i] 和 arr[i + 1] 的大小
         *      i.如果 arr[i] > arr[i + 1]，那么交换两者的位置，再接着比较 arr[i + 1] 和 arr[i + 2] 的大小
         *      ii.如果 arr[i] <= arr[i + 1]，那么就直接接着比较 arr[i + 1] 和 arr[i + 2] 的大小
         * 2.第 i 次遍历的时候，从 arr[0] 开始遍历到 arr[n - i]，也就是第 0 次遍历的时候，遍历到 arr[0...n]，
         * 第  1 次遍历的时候，遍历到 arr[0...n - 1]，也就是第 n 个位置上的数已经确定了
         */
        for (int m = 0; m < arr.length; m++) {
            int i = 0;
            for (int j = i + 1, k = i; j < arr.length - m; j++, k++) {
                if (arr[j] < arr[k]){
                    int temp = arr[k];
                    arr[k] = arr[j];
                    arr[j] = temp;
                }
            }
        }
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
}
