package xu.graph.solutions;

import java.util.*;

public class Solution399 {

    /*
     * 除法求值
     *
     * 这道题目首先根据条件生成一个图的邻接矩阵 edges，生成一个无向图，接着对要求的每一个 query 使用 dfs 的方法进行遍历。
     */

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<String> verts = new ArrayList<>();
        for (List<String> equation : equations) {
            if (!verts.contains(equation.get(0)))
                verts.add(equation.get(0));
            if (!verts.contains(equation.get(1)))
                verts.add(equation.get(1));
        }

        double[][] edges = new double[verts.size()][verts.size()];
        for (int i = 0; i < edges.length; i++) {
            edges[i][i] = 1;
        }

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            int row = verts.indexOf(equation.get(0));
            int col = verts.indexOf(equation.get(1));
            edges[row][col] = values[i];
            edges[col][row] = 1 / values[i];
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            int row = verts.indexOf(query.get(0));
            int col = verts.indexOf(query.get(1));

            if (row == -1 || col == -1)
                ans[i] = -1;
            else if (edges[row][col] != 0)
                ans[i] = edges[row][col];
            else
                ans[i] = func(edges, row, col, new HashSet<>());
        }

        return ans;
    }

    private double func(double[][] edges, int row, int col,Set<Integer> visited) {
        if (edges[row][col] != 0)
            return edges[row][col];

        visited.add(row);
        for (int i = 0; i < edges[row].length; i++) {
            if (edges[row][i] != 0 && !visited.contains(i)){
                double tmp = func(edges, i, col, visited);
                if (tmp != -1){
                    return tmp * edges[row][i];
                }
            }
        }

        return -1;
    }

}
