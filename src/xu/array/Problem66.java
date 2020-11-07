package xu.array;

import java.util.Arrays;

public class Problem66 {

    public int[] plusOne(int[] digits) {
        if (digits == null)
            return null;

        if (digits.length == 0)
            return new int[0];

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
            carry = tmp;
        }

        if (carry != 0){
            int[] ans = new int[digits.length + 1];
            for (int i = 0; i < ans.length; i++) {
                if (i == 0)
                    ans[i] = carry;
                else
                    ans[i] = digits[i - 1];
            }

            return ans;
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem66().plusOne(new int[]{0})));
        System.out.println(Arrays.toString(new Problem66().plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new Problem66().plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(new Problem66().plusOne(new int[]{9,9,9})));
        System.out.println(Arrays.toString(new Problem66().plusOne(new int[]{2,4,9})));
    }

}
