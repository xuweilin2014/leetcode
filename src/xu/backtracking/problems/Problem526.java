package xu.backtracking.problems;

public class Problem526 {

    private int counter = 0;
    private int[] visited;

    public int countArrangement(int N) {
        this.visited = new int[N];
        dfs(1, N, N);
        return counter;
    }

    private void dfs(int index, int length, int N) {
        if (index > length){
            counter++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1)
                continue;
            int val = i + 1;
            if (val % index != 0 && index % val != 0){
                continue;
            }
            visited[i] = 1;
            dfs(index + 1, length, N);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem526().countArrangement(2));
    }
}
