package xu.backtracking;

public class Problem52 {

    private static int[] pos;
    private int val = 0;

    public int totalNQueens(int n) {
        getQueue(n);
        return val;
    }


    public void getQueue(int n){
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
            if (pos[k] <= n && k == n - 1) val++;
            if (pos[k] <= n && k < n - 1) k++;
            else pos[k--] = 0;
        }
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
}
