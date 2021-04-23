package xu.graph;

public class Problem997 {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N];
        int[] outdegree = new int[N];
        for (int i = 0; i < trust.length; i++) {
            indegree[trust[i][1] - 1]++;
            outdegree[trust[i][0] - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (outdegree[i] == 0 && indegree[i] == N - 1)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem997().findJudge(4, new int[][]{
                {1, 3}, {1, 4}, {2,3}, {2, 4}, {4,3}
        }));
    }
}
