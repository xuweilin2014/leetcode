package xu.union_find;

public class Problem1319 {

    private int[] parents;

    public int find(int vert){
        while (parents[vert] != vert){
            vert = parents[vert];
        }
        return vert;
    }

    public void union(int i, int j){
        parents[find(j)] = find(i);
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < connections.length; i++) {
            union(connections[i][0], connections[i][1]);
        }
        int ans = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i)
                ans++;
        }

        return ans - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1319().makeConnected(5, new int[][]{
                {0,1},{0,2},{3,4},{2,3}
        }));
    }
}
