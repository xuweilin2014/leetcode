package offer.question11_20.solutions;

public class QSolution11 {

    /*
     * 旋转数组的最小数字
     *
     * 这道题目使用二分法来进行求解，旋转数组 array 可以被看成是两个递增数组的组合，low 和 high 、
     * 最开始分别指向数组 array 的两端，计算出 mid。
     * 如果 array[mid] < array[high]，那么就说明中间元素 mid 位于后面的递增数组，让 high = mid
     * 如果 array[mid] > array[low]，那么就说明中间元素 mid 位于前面的递增数组，让 low = mid
     * 按照上述思路，第一个指针总是指向前面递增数组的元素，而第二个指针总是指向后面递增数组的元素。
     * 最终它们总是会指向两个相邻的元素
     */

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return 0;

        return func(array, 0, array.length - 1);
    }

    private int func(int[] array, int low, int high) {
        if (low == high - 1)
            return Math.min(array[low], array[high]);

        int mid = (low + high) / 2;

        if (array[mid] < array[high]){
            return func(array, low, mid);
        }else {
            return func(array, mid, high);
        }
    }

}
