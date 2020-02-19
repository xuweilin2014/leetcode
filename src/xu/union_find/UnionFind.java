package xu.union_find;


public class UnionFind {

    public int[] parents;

    public UnionFind(int len) {
        parents = new int[len];
        for (int i = 0; i < len; i++) {
            parents[i] = i;
        }
    }

    public int find(int vert){
        int trail = vert;
        while (parents[vert] != vert){
            vert = parents[vert];
        }
        int root = vert, lead;
        for (int v = trail; v != root; v = lead){
            lead = parents[v];
            parents[v] = root;
        }
        return root;
    }

    public void union(int i, int j){
        parents[find(j)] = find(i);
    }

}
