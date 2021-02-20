package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {

    private List<List<Integer>> ips = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        func(s.toCharArray(), new ArrayList<>(), 0);
        List<String> ans = new ArrayList<>();
        for (List<Integer> ip : ips) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < ip.size(); i++) {
                str.append(ip.get(i)).append(".");
            }
            str.deleteCharAt(str.length() - 1);
            ans.add(str.toString());
        }

        return ans;
    }

    private void func(char[] chs, List<Integer> path, int index){
        if (path.size() > 4)
            return;

        if (index == chs.length){
            if (path.size() == 4) {
                ips.add(new ArrayList<>(path));
            }
            return;
        }

        int val = 0;
        for (int i = index; i < chs.length; i++) {
            val = val * 10 + chs[i] - '0';
            if (val > 255)
                break;

            path.add(val);
            func(chs, path, i + 1);
            path.remove(path.size() - 1);

            if (chs[i] == '0' && val == 0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<String> lists = new Problem93().restoreIpAddresses("010010");
        for (String list : lists) {
            System.out.println(list);
        }

        lists = new Problem93().restoreIpAddresses("25525511135");
        for (String list : lists) {
            System.out.println(list);
        }

        lists = new Problem93().restoreIpAddresses("1111");
        for (String list : lists) {
            System.out.println(list);
        }
    }
}
