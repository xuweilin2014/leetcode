package algorithm_analysis_and_design.dynamic_programming;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(1));
    }

    public static int fib(int N) {
        int[] vals = new int[N + 1];
        for (int i = 0; i < vals.length; i++) {
            if (i == 0 || i == 1) {
                vals[i] = i;
            }else {
                vals[i] = vals[i - 1] + vals[i - 2];
            }
        }

        return vals[N];
    }

}
