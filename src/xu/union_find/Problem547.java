package xu.union_find;

public class Problem547 {

    private int[] parents;
    private int length;

    public int find(int vert){
        while (parents[vert] < length){
            vert = parents[vert];
        }
        return vert;
    }

    public void union(int i, int j){
        parents[j] = i;
    }

    public int findCircleNum(int[][] M) {
        parents = new int[M.length];
        length = M.length;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i + length;
        }
        int counter = M.length;
        for (int row = 0; row < M.length; row++) {
            for (int col = 0; col < row; col++) {
                if (M[row][col] == 1){
                    if (find(row) == find(col))
                        continue;
                    union(find(row), find(col));
                    counter--;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem547().findCircleNum(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }));
    }
}
