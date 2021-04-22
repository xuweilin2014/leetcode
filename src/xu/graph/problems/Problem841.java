package xu.graph.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[][] graph = new int[rooms.size()][rooms.size()];
        Set<Integer> visited = new HashSet<>();
        int counter = 0;
        for (List<Integer> room : rooms) {
            for (int key : room) {
                if (key != counter){
                    graph[counter][key] = 1;
                }
            }
            counter++;
        }

        dfs(graph, 0, visited);
        if (visited.size() < rooms.size())
            return false;

        return true;
    }

    private void dfs(int[][] graph, int index, Set<Integer> visited) {
        if (visited.contains(index))
            return;

        visited.add(index);
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] == 1 && !visited.contains(i))
                dfs(graph, i, visited);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(3);
        List<Integer> l4 = new ArrayList<>();
        rooms.add(l1);
        rooms.add(l2);
        rooms.add(l3);
        rooms.add(l4);
        System.out.println(new Problem841().canVisitAllRooms(rooms));
    }
}
