package xu.graph;

public class Problem684 {

    private String[] names;
    private int[] parents;
    private int[] res = new int[2];
    private int length;

    public String find(int vert){
        while (parents[vert] <= length){
            vert = parents[vert];
        }
        return names[parents[vert] - length];
    }

    public int getRoot(int vert){
        while (parents[vert] <= length){
            vert = parents[vert];
        }
        return vert;
    }

    public void union(int i, int j){
        parents[j] = i;
    }

    public int[] findRedundantConnection(int[][] edges) {
        length = edges.length;
        parents = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parents[i] = i + edges.length;
        }
        names = new String[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            names[i] = String.valueOf(i);
        }

        for (int[] edge : edges) {
            if (find(edge[0]).equals(find(edge[1]))){
                res[0] = edge[0];
                res[1] = edge[1];
                continue;
            }
            union(getRoot(edge[0]), getRoot(edge[1]));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] connections = new Problem684().findRedundantConnection(new int[][]{
                {1, 4},
                {3, 4},
                {1, 3},
                {1, 2},
                {4, 5}
        });
        System.out.println(connections[0] + " " + connections[1]);
    }
}
