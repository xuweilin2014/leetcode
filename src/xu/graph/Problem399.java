package xu.graph;

import java.util.*;

public class Problem399 {

    private double[] res;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> verts = new HashSet<>();
        for (List<String> equation : equations) {
            verts.add(equation.get(0));
            verts.add(equation.get(1));
        }
        List<String> vs = new ArrayList<>(verts);
        double[][] graph = new double[verts.size()][verts.size()];
        for (int i = 0; i < equations.size(); i++) {
            int row = vs.indexOf(equations.get(i).get(0));
            int col = vs.indexOf(equations.get(i).get(1));
            graph[row][col] = values[i];
            graph[col][row] = 1 / values[i];
        }
        res = new double[queries.size()];
        Arrays.fill(res, -1);
        for (int i = 0; i < queries.size(); i++) {
            double[] visited = new double[verts.size()];
            int x = vs.indexOf(queries.get(i).get(0));
            int y = vs.indexOf(queries.get(i).get(1));
            if (!verts.contains(queries.get(i).get(0)) ||
                    !verts.contains(queries.get(i).get(1))) {
                continue;
            }
            dfs(graph, x, y, visited, i, 1);
        }

        return res;
    }

    private void dfs(double[][] graph, int start, int end, double[] visited, int counter, double product) {
        if (start == end) {
            res[counter] = product;
            return;
        }

        visited[start] = 1;
        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] != 0 && visited[i] == 0){
                dfs(graph, i, end, visited, counter, product * graph[start][i]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");l1.add("b");
        List<String> l2 = new ArrayList<>();
        l2.add("c");l2.add("d");
        List<String> l3 = new ArrayList<>();
        l3.add("bc");l3.add("cd");
        equations.add(l1);
        equations.add(l2);
        /*equations.add(l3);*/
        double[] vals = new double[]{2,1};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        List<String> q2 = new ArrayList<>();
        List<String> q3 = new ArrayList<>();
        List<String> q4 = new ArrayList<>();
        List<String> q5 = new ArrayList<>();
        q1.add("a");q1.add("c");
        q2.add("b");q2.add("d");
        q3.add("b");q3.add("a");
        q4.add("d");q4.add("c");
        /*q5.add("a");q5.add("a");*/
        queries.add(q1);queries.add(q2);queries.add(q3);queries.add(q4);
        double[] doubles = new Problem399().calcEquation(equations, vals, queries);
        for (double aDouble : doubles) {
            System.out.print(aDouble + " ");
        }
    }


}
