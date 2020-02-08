package algorithm_analysis_and_design.backtracking;

/**
 * 使用回溯法来解决素数环问题
 */

public class PrimeCircle {

    private static int[] vals;

    public boolean getPrimeCircle(int n){
        vals = new int[n];
        vals[0] = 1;
        int k = 1;
        while (k >= 1){
            vals[k] = vals[k] + 1;
            while (vals[k] <= n){
                if (isValid(k, n)){
                    break;
                }else{
                    vals[k]++;
                }
            }

            if (vals[k] <= n && k == n - 1){
                return true;
            }

            if (vals[k] <= n && k < n - 1){
                k++;
            }else{
                vals[k--] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int index, int n) {
        for (int i = index - 1; i >= 0; i--){
            if (vals[index] == vals[i])
                return false;
        }

        boolean flag = isPrime(vals[index] + vals[index - 1]);
        boolean flag1 = true;
        if (flag && index == n - 1){
            flag1 = isPrime(vals[index] + vals[0]);
        }
        return flag1 && flag;
    }

    private boolean isPrime(int val) {
        double n = Math.sqrt(val);
        for (int i = 2; i <= n; i++){
            if (val % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = new PrimeCircle().getPrimeCircle(13);
        if (flag){
            for (int i = 0; i < vals.length; i++) {
                System.out.print(vals[i] + " ");
            }
        }else{
            System.out.println("无解");
        }

    }

}
