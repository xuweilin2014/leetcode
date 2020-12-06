package xu.two_pointer;

import java.util.Arrays;

public class Problem80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2])
                nums[i++] = num;

        }

        return i;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        printResult(ints);

        ints = new int[]{1,1,1,2,2,3};
        printResult(ints);

        ints = new int[]{1,2,3,4,5,6};
        printResult(ints);

        ints = new int[]{1,1,1,1,1,1};
        printResult(ints);

        ints = new int[]{1,1,1};
        printResult(ints);

        ints = new int[]{1,1,1,2,2,2};
        printResult(ints);

        ints = new int[]{1,1};
        printResult(ints);

        ints = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 3};
        printResult(ints);

        ints = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 3,4,6,7,7,7,7,7,8,9,9,9,9};
        printResult(ints);
    }

    private static void printResult(int[] ints){
        System.out.println("original: " + Arrays.toString(ints));
        int len = new Problem80().removeDuplicates(ints);
        System.out.print("new: [");
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.print("]\n");
    }



}
