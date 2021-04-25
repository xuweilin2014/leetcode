package xu.union_find.problems;

import xu.union_find.UnionFind;

public class Problem959 {
    
    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        UnionFind uf = new UnionFind(rows * cols * 4);

        int base = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = grid[i].charAt(j);
                base = i * cols * 4 + j * 4;
                if (ch == '/'){
                    uf.union(base, base + 3);
                    uf.union(base + 1, base + 2);
                }else if (ch == '\\'){
                    uf.union(base, base + 1);
                    uf.union(base + 2, base + 3);
                }else if (ch == ' '){
                    uf.union(base, base + 1);
                    uf.union(base, base + 2);
                    uf.union(base, base + 3);
                }

                if (i + 1 < rows){
                    uf.union(base + 2, base + cols * 4);
                }
                if (j + 1 < cols){
                    uf.union(base + 1, base + 7);
                }
            }
        }

        int counter = 0;
        for (int parent : uf.parents) {
            if (parent == -1)
                counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem959().regionsBySlashes(new String[]{
                "/\\",
                "\\/"
        }));
    }
}
