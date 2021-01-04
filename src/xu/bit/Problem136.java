package xu.bit;

public class Problem136 {

    public int singleNumber(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            unique = unique ^ num;
        }

        return unique;
    }

    public static void main(String[] args) {
        System.out.println(new Problem136().singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(new Problem136().singleNumber(new int[]{2,2,1}));
    }

}
