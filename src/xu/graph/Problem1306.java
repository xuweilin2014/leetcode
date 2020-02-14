package xu.graph;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1306 {

    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start);
    }

    private boolean dfs(int[] arr, int st) {
        if (st >= 0 && st < arr.length && arr[st] < arr.length){
            int jump = arr[st];
            //用来防止对节点的重复遍历，起到visited的作用
            arr[st] += arr.length;
            return jump == 0 || dfs(arr, st + jump) || dfs(arr, st - jump);
        }
        return false;
    }

    public boolean solution1(int[] arr, int start) {
        List<Set<Integer>> adj = new ArrayList<>();
        int[] visited = new int[arr.length];
        for (int i = 0; i < arr.length; i++) adj.add(new HashSet<>());
        for (int i = 0; i < arr.length; i++) {
            if (i - arr[i] >= 0 && arr[i] != 0)
                adj.get(i).add(i - arr[i]);
            if (i + arr[i] < arr.length && arr[i] != 0)
                adj.get(i).add(i + arr[i]);
        }
        List<Integer> queue = new ArrayList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            List<Integer> newQueue = new ArrayList<>();
            for (int cur : queue) {
                visited[cur] = 1;
                if (arr[cur] == 0)
                    return true;
                for (int v : adj.get(cur)) {
                    if (visited[v] == 0)
                        newQueue.add(v);
                }
            }
            queue = newQueue;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1306().canReach(new int[]{4,2,3,0,3,1,2}, 0));
    }
}
