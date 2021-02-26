package xu.union_find;

public class Problem959 {

    private int[] parents;
    private int length;
    private int counter;

    public int find(int vert){
        while (parents[vert] != vert){
            vert = parents[vert];
        }
        return vert;
    }

    public void union(int i, int j){
        parents[find(j)] = find(i);
    }

    public int regionsBySlashes(String[] grid) {
        counter = grid.length * grid.length * 4;
        length = counter;
        int[][][] areas = new int[grid.length][grid.length][4];
        parents = new int[counter];
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int m = 0; m < 4; m++) {
                    areas[i][j][m] = k;
                    parents[k] = k;
                    k++;
                }
            }
        }
        int base = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (j + 1 < grid.length) {
                    union(areas[i][j][1], areas[i][j+1][3]);
                }
                if (i + 1 < grid.length){
                    union(areas[i][j][2], areas[i+1][j][0]);
                }
                if (i - 1 >= 0){
                    union(areas[i][j][0], areas[i-1][j][2]);
                }
                if (j - 1 >= 0){
                    union(areas[i][j][3], areas[i][j-1][1]);
                }
                if (grid[i].charAt(j) == ' '){
                    union(areas[i][j][0], areas[i][j][1]);
                    union(areas[i][j][0], areas[i][j][2]);
                    union(areas[i][j][0], areas[i][j][3]);
                }
                if (grid[i].charAt(j) == '/'){
                    union(areas[i][j][0], areas[i][j][3]);
                    union(areas[i][j][1], areas[i][j][2]);
                }
                if (grid[i].charAt(j) == '\\'){
                    union(areas[i][j][0], areas[i][j][1]);
                    union(areas[i][j][3], areas[i][j][2]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < parents.length; i++) {
            if (find(i) == i)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem959().regionsBySlashes(new String[]{
                "/\\",
                "\\/"
        }));
    }
}
