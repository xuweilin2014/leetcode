package xu.dp;

public class Problem70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] stairs = new int[n + 1];
        stairs[1] = 1;
        stairs[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
    }

}
