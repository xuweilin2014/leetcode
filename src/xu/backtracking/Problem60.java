package xu.backtracking;

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
        List<Integer> arr = new ArrayList<>();
        int factorial = 1;
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
            factorial *= (i + 1);
        }
        int len = n;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() != len){
            factorial /= n--;
            if (k % factorial != 0)
                index = k / factorial + 1;
            else
                index = k / factorial;
            sb.append(arr.get(index - 1));
            arr.remove(index - 1);
            k = k - (index - 1) * factorial;
        }
        return sb.toString();
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
        System.out.println(new Problem60().getPermutation(4, 2));
    }
}
