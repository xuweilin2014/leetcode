package xu.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法
 */
public class Problem376 {

    public int wiggleMaxLength(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            arr.add(nums[i]);
        }

        if (arr.size() <= 2)
            return arr.size();

        int counter = 2;
        int next = arr.get(1);
        boolean positive = arr.get(1) > arr.get(0);

        for (int i = 2; i < arr.size(); i++) {
            if ((arr.get(i) > next) != positive) {
                positive = arr.get(i) > next;
                counter++;
            }

            next = arr.get(i);
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem376().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(new Problem376().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new Problem376().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(new Problem376().wiggleMaxLength(new int[]{1, 7, 4, 4, 2, 5}));
        System.out.println(new Problem376().wiggleMaxLength(new int[]{0,0,0}));
        System.out.println(new Problem376().wiggleMaxLength(new int[]{0,0,0, -1, 7}));
    }

}
