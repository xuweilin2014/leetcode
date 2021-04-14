package offer.question31_40.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question40 {

    public static void main(String[] args) {
        System.out.println(new Question40().GetLeastNumbers_Solution(new int[]{0,0,2,3,2,1,1,2,0,4}, 1));
        System.out.println(new Question40().GetLeastNumbers_Solution(new int[]{0,0,2,3,2,1,1,2,0,4}, 10));
    }

    // 使用快排的思想
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length)
            return new ArrayList<>();

        func(input, 0, input.length - 1, k);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }

        return ans;
    }

    private void func(int[] input, int left, int right, int k) {
        if (left >= right)
            return;

        int pivot = input[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && input[high] >= pivot)
                high--;
            if (low < high){
                input[low] = input[high];
                low++;
            }
            while (low < high && input[low] <= pivot)
                low++;
            if (low < high){
                input[high] = input[low];
                high--;
            }
        }
        input[low] = pivot;

        if (low < k)
            func(input, low + 1, right, k);
        if (low > k)
            func(input, left, low - 1, k);

    }


}
