package xu.backtracking.problems;

import java.util.*;

public class Problem1079 {

    private boolean[] visited;

    private int ans = 0;

    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0)
            return 0;

        visited = new boolean[tiles.length()];
        char[] chs = tiles.toCharArray();
        Arrays.sort(chs);
        func(chs, new StringBuilder(), 0);
        return ans;
    }

    private void func(char[] chs, StringBuilder path, int layer){
        if (layer > chs.length)
            return;

        if (!"".equals(path.toString()))
            ans++;

        for (int i = 0; i < chs.length; i++) {
            if (visited[i])
                continue;
            if (i - 1 >= 0 && chs[i] == chs[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;
            path.append(chs[i]);
            func(chs, path, layer + 1);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem1079().numTilePossibilities("AAB"));
        System.out.println(new Problem1079().numTilePossibilities("AAABBC"));
    }
}
