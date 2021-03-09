package xu.dfs.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1306 {

    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0)
            return false;

        int[] visited = new int[arr.length];
        return func(arr, start, visited);
    }

    private boolean func(int[] arr, int index, int[] visited) {
        if (index < 0 || index >= arr.length || visited[index] == 1)
            return false;
        if (arr[index] == 0)
            return true;

        visited[index]++;

        int ai = index + arr[index];
        int bi = index - arr[index];

        boolean before = func(arr, bi, visited);
        boolean after = func(arr, ai, visited);

        return before || after;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1306().canReach(new int[]{1,1,1,1,1,1,1,1,0}, 3));
        System.out.println(new Problem1306().canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(new Problem1306().canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(new Problem1306().canReach(new int[]{3,0,2,1,2}, 2));
    }
}
