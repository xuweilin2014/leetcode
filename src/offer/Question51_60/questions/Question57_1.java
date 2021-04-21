package offer.Question51_60.questions;

import java.util.ArrayList;
import java.util.List;

public class Question57_1 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length == 0)
            return new ArrayList<>();

        int low = 0;
        int high = array.length - 1;
        List<ArrayList<Integer>> arr = new ArrayList<>();
        int multi = Integer.MAX_VALUE;

        while (low < high){
            int val = array[low] + array[high];
            if (val > sum)
                high--;
            else if (val == sum){
                ArrayList<Integer> copy = new ArrayList<>();
                copy.add(array[low]);
                copy.add(array[high]);
                arr.add(copy);
                multi = Math.min(array[low] * array[high], multi);
                high--;
            }else {
                low++;
            }
        }

        for (ArrayList<Integer> vals : arr) {
            if (vals.get(0) * vals.get(1) == multi)
                return vals;
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println((new Question57_1().FindNumbersWithSum(new int[]{5,5,10}, 10)));
    }

}
