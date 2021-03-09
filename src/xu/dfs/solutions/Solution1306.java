package xu.dfs.solutions;

public class Solution1306 {

    /*
     * 跳跃游戏 III
     *
     * 这是典型的深度优先搜索，对于每一个点，有两条分支可以选择，向前跳跃 arr[i] 步，或者向后跳跃 arr[i] 步。
     * 另外，需要创建一个 int 数组 visited 保存已经访问过的节点。注意，这里使用 int 数组而不是 List 集合类，
     * 否则，会出现超时现象。
     */

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

}
