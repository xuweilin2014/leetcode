package xu.dfs.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem886 {

    private int[] visited;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        visited = new int[N];
        List<Set<Integer>> verts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            verts.add(new HashSet<>());
        }
        for (int i = 0; i < dislikes.length; i++) {
            verts.get(dislikes[i][0]-1).add(dislikes[i][1]-1);
            verts.get(dislikes[i][1]-1).add(dislikes[i][0]-1);
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0){
                visited[i] = 1;
                if (!dfs(verts, i))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Set<Integer>> verts, int vs) {

        for (int v : verts.get(vs)) {
            if (visited[v] == 0){
                visited[v] = visited[vs] == 1? 2 : 1;
                dfs(verts, v);
            }else{
                if (visited[v] == visited[vs])
                    return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Problem886().possibleBipartition(5, new int[][]{
                {1, 2},
                {2,4},
                {3,4},
                {4, 5}
        }));
    }


}
