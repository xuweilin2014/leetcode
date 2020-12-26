package xu.two_pointer.problems;

public class Problem1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int prefix = 0;
        int max = 0;

        for (int i = 0; i < customers.length; i++) {
            if (i < X && grumpy[i] == 1){
                prefix += customers[i];
            }
        }

        for (int i = 0; i < customers.length - X + 1; i++) {
            if (i > 0){
                if (grumpy[i - 1] == 1){
                    prefix -= customers[i - 1];
                }
                if (grumpy[i + X - 1] == 1){
                    prefix += customers[i + X - 1];
                }
            }
            max = Math.max(prefix, max);
        }

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                max += customers[i];
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1052().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

}
