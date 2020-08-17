package offer.question31_40;

public class Question39 {

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1}));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 1)
            return array[0];
        int index = func(array, array.length / 2, 0, array.length - 1);
        if (checkIsValid(array, array[index]))
            return array[index];
        else
            return 0;
    }

    public static int func(int[] arr, int k, int left, int right){
        int pivot = arr[left];
        int low = left;
        int high = right;

        while (low < high){
            while (low < high && pivot <= arr[high])
                high--;

            if (low < high)
                arr[low] = arr[high];

            while (low < high && pivot >= arr[low])
                low++;

            if (low < high)
                arr[high] = arr[low];
        }

        arr[high] = pivot;

        if (k == high)
            return pivot;
        else if (k > high)
            return func(arr, k, left + 1, right);
        else
            return func(arr, k, left, right - 1);
    }

    public static boolean checkIsValid(int[] arr, int target){
        int times = 0;
        for (int val : arr) {
            if (val == target)
                times++;
        }

        if (times > arr.length / 2)
            return true;
        else
            return false;
    }

}
