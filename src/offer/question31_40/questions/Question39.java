package offer.question31_40.questions;

public class Question39 {

    public static void main(String[] args) {
        System.out.println(new Question39().majorityElement(new int[]{3,2,3,2,3,3,3,3,3,2,2,3,3,5,4,2}));
        System.out.println(new Question39().majorityElement(new int[]{1,2,3}));
    }

    // 分治算法
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 1)
            return array[0];
        int index = func(array, array.length / 2, 0, array.length - 1);
        if (checkIsValid(array, array[index]))
            return array[index];
        else
            return 0;
    }

    // 摩尔投票法
    public int majorityElement(int[] array) {
        if (array.length == 1)
            return array[0];

        int counter = 1;
        int val = array[0];

        for (int i = 1; i < array.length; i++) {
            if (counter == 0){
                counter++;
                val = array[i];
                continue;
            }

            if (array[i] == val){
                counter++;
            }else{
                counter--;
            }
        }

        return val;
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
            return k;
        else if (k > high)
            return func(arr, k, high + 1, right);
        else
            return func(arr, k, left, high - 1);
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
