package xu.graph.problems;

import java.util.*;

public class Problem399 {

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

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");l1.add("b");
        List<String> l2 = new ArrayList<>();
        l2.add("b");l2.add("c");
        List<String> l3 = new ArrayList<>();
        l3.add("c");l3.add("d");
        List<String> l4 = new ArrayList<>();
        l4.add("d");l4.add("e");
        equations.add(l1);
        equations.add(l2);
        equations.add(l3);
        equations.add(l4);
        double[] vals = new double[]{3.0,4.0,5.0,6.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        List<String> q2 = new ArrayList<>();
        List<String> q3 = new ArrayList<>();
        List<String> q4 = new ArrayList<>();
        List<String> q5 = new ArrayList<>();
        q1.add("a");q1.add("e");
        q2.add("e");q2.add("b");
        q3.add("b");q3.add("d");
        q4.add("b");q4.add("b");
        q5.add("x");q5.add("x");
        queries.add(q1);queries.add(q2);queries.add(q3);queries.add(q4);queries.add(q5);
        double[] doubles = new Problem399().calcEquation(equations, vals, queries);
        for (double aDouble : doubles) {
            System.out.print(aDouble + " ");
        }
    }


}
