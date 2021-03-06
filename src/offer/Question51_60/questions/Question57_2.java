package offer.Question51_60.questions;

import xu.linkedlist.problems.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Question57_2 {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if (sum == 0)
            return new ArrayList<>();

        int low = 1;
        int high = 2;
        int win = 3;
        ArrayList<Integer[]> arr = new ArrayList<>();
        while (low < sum){
            if (win < sum) {
                high++;
                win = win + high;
            }else if (win == sum){
                arr.add(new Integer[]{low, high});
                low++;
                win = win - (low - 1);
            }else {
                low++;
                win = win - (low - 1);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (Integer[] vals : arr) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = vals[0]; i <= vals[1]; i++) {
                tmp.add(i);
            }
            ans.add(tmp);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Question57_2().FindContinuousSequence(15));
    }

}
