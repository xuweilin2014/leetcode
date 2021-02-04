package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int[] vals = changeToInt(s);
        List<String> stringList = new ArrayList<>();
        dfs(vals, 0,new ArrayList<>());
        for (List<Integer> re : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < re.size(); i++) {
                sb.append(re.get(i));
                if (i != re.size() - 1)
                    sb.append(".");
            }
            stringList.add(sb.toString());
        }
        return stringList;
    }

    private void dfs(int[] vals, int index, List<Integer> path) {
        if (index == vals.length && path.size() == 4){
            res.add(new ArrayList<>(path));
            return;
        }

        if (path.size() == 4)
            return;

        int sum = 0;
        for (int i = index; i <= index + 2 && i < vals.length; i++){
            sum = sum * 10 + vals[i];
            if (sum > 255)
                continue;
            path.add(sum);
            dfs(vals, i + 1, path);
            path.remove(path.size() - 1);
            if (sum == 0)
                return;
        }
    }

    private int[] changeToInt(String s) {
        int[] vals = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            vals[i] = s.charAt(i) - '0';
        }
        return vals;
    }

    public static void main(String[] args) {
        List<String> lists = new Problem93().restoreIpAddresses("010010");
        for (String list : lists) {
            System.out.println(list);
        }
    }
}
