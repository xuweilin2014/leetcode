package offer.Question51_60.questions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列，这里的队列为双端队列
 */
public class Question59_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)
            return new int[]{};

        // 双端队列
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            res[i - k] = deque.getFirst();
            if (deque.getFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.getLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }

        res[res.length - 1] = deque.getFirst();

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question59_1().maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
    }

}
