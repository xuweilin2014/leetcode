package xu.bit;

import java.util.Arrays;

public class Problem260 {

    public int[] singleNumber(int[] nums) {
        int bitSum = 0;
        for (int num : nums) {
            bitSum ^= num;
        }

        int counterOf1 = 1;
        while ((bitSum & counterOf1) != counterOf1) {
            counterOf1 = counterOf1 << 1;
        }

        int[] val = new int[2];
        for (int num : nums) {
            if ((num & counterOf1) == counterOf1)
                val[0] = val[0] ^ num;
            else
                val[1] = val[1] ^ num;
        }

        return val;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem260().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(new Problem260().singleNumber(new int[]{1, 2, 1, 4, 2, 5, 4, 7})));
        System.out.println(Arrays.toString(new Problem260().singleNumber(new int[]{3,4})));
    }

}
