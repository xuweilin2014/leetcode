package xu.backtracking;

import xu.tree.Problem508;

import java.util.ArrayList;
import java.util.List;

public class Problem60 {

    private int counter = 0;
    private boolean flag = true;
    private List<Integer> last;

    public String getPermutation(int n, int k) {
        return solution2(n, k);
    }

    public String solution2(int n, int k){
        int[] visited = new int[n];
        int f = getFactorial(n - 1);
        int val = 0;
        String res = "";
        int len = n;
        int counter = 0;
        while (res.length() != len){
            if (k % f != 0) {
                val = k / f + 1;
            }else{
                val = k / f;
            }
            if (val != 1)
                k = k - f * (val - 1);
            for (int i = 0; i < len; i++) {
                if (visited[i] == 1)
                    continue;
                counter++;
                if (counter == val) {
                    res += i + 1;
                    visited[i] = 1;
                    break;
                }
            }
            n--;
            f = getFactorial(n - 1);
            counter = 0;
        }
        return res;
    }

    private int getFactorial(int n) {
        int val = 1;
        for (int i = n; i > 0; i--) {
            val *= i;
        }
        return val;
    }

    public String solution1(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= nums.length; i++) {
            nums[i - 1] = i;
        }
        int[] visited = new int[n];
        dfs(nums, visited, new ArrayList<>(), 0, n, k);
        String res = "";
        for (int i = 0; i < last.size(); i++) {
            res += last.get(i);
        }
        return res;
    }

    private void dfs(int[] nums, int[] visited, List<Integer> path, int index, int length, int k) {
        if (index == length){
            counter++;
            if (counter == k) {
                flag = false;
                last = new ArrayList<>(path);
            }
            return;
        }

        if (flag){
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1)
                    continue;

                visited[i] = 1;
                path.add(nums[i]);
                dfs(nums, visited, path, index + 1, length, k);
                path.remove(path.size() - 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem60().getPermutation(3, 5));
    }
}
