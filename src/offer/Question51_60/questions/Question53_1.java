package offer.Question51_60.questions;


public class Question53_1 {

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


    public static void main(String[] args) {
        System.out.println(new Question53_1().GetNumberOfK(new int[]{1,2,3,3,3,3,4,5}, 3));
    }

}
