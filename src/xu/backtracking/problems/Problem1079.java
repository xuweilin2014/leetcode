package xu.backtracking.problems;

import java.util.HashSet;
import java.util.Set;

public class Problem1079 {

    private Set<String> list = new HashSet<>();
    private int sum = 0;

    public int numTilePossibilities(String tiles) {
        return solutionFinal(tiles);
    }

    private int solutionFinal(String tiles) {
        int[] arr = new int[26];
        char[] chars = tiles.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'A']++;
        }
        dfs(arr);
        return sum;
    }

    private void dfs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;

            sum++;
            arr[i]--;
            dfs(arr);
            arr[i]++;
        }
    }

    private int solution1(String tiles) {
        char[] chars = tiles.toCharArray();
        int[] visited = new int[tiles.length()];
        func(chars, visited, 0, tiles.length(), "");
        return list.size();
    }

    private void func(char[] chars, int[] visited, int index, int length, String path) {
        if (index == length){
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            String tmp = new StringBuilder().append(path).append(chars[i]).toString();
            if (!list.contains(tmp) && visited[i] == 0){
                list.add(tmp);
                visited[i] = 1;
                func(chars, visited, index + 1, length, tmp);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem1079().numTilePossibilities("AABB"));
    }
}
