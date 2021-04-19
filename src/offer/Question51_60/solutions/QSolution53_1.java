package offer.Question51_60.solutions;

public class QSolution53_1 {

    /*
     * 数字在排序数组中出现的次数
     *
     * 这道题目需要使用二分查找，在排序数组中分别找到 target 第一次出现的位置 low，以及 target 最后一次出现的位置 high，
     * 最后，high - low + 1 得到的结果就是 target 出现的次数
     */

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0)
            return 0;

        int low = getFirstK(array, 0, array.length - 1, k);
        int high = getLastK(array, 0, array.length - 1, k);

        if (low != -1 && high != -1){
            return high - low + 1;
        }

        return 0;
    }

    private int getFirstK(int[] array, int low, int high, int k){
        while (low <= high){
            int mid = (low + high) / 2;
            if (array[mid] > k){
                high = mid - 1;
            } else if (array[mid] < k){
                low = mid + 1;
            } else if (mid - 1 >= 0 && array[mid - 1] == k){
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private int getLastK(int[] array, int low, int high, int k){
        while (low <= high){
            int mid = (low + high) / 2;
            if (array[mid] > k){
                high = mid - 1;
            } else if (array[mid] < k){
                low = mid + 1;
            } else if (mid + 1 < array.length && array[mid + 1] == k){
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
