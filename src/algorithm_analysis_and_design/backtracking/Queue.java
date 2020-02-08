package algorithm_analysis_and_design.backtracking;

/**
 * 使用回溯法解决 n 皇后问题
 */

public class Queue {

    private static int[] pos;

    public boolean getQueue(int n){
        pos = new int[n];
        int k = 0;
        while (k >= 0){
            pos[k] = pos[k] + 1;
            while (pos[k] <= n){
                if (isValid(k)){
                    break;
                }
                pos[k]++;
            }
            if (pos[k] <= n && k == n - 1) return true;
            if (pos[k] <= n && k < n - 1) k++;
            else pos[k--] = 0;
        }
        return false;
    }

    private boolean isValid(int k) {
        for (int i = k - 1; i >= 0; i--){
            if (pos[i] == pos[k])
                return false;

            if (Math.abs(i - k) == Math.abs(pos[i] - pos[k]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = new Queue().getQueue(5);
        if (flag){
            for (int i = 0; i < pos.length; i++) {
                System.out.print(pos[i] + " ");
            }
        }else{
            System.out.println("无解");
        }
    }

}
