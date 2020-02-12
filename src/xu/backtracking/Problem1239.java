package xu.backtracking;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用逻辑运算符&和 | 的性质来判断两个字符串是否具有相同的字符。
 * 具体实现是：每个字符都有一个ASCII码值，遍历一个字符串，把每个字符(ASCII码值为C)都转化成1 << C，
 * 然后将所有字符的转化形式都这样或(|)在一起。 最后将两个字符串的 | 结果相&，如果没有相同的字符那么结果为零，
 * 如果有相同的字符结果不为零。
 */

public class Problem1239 {

    private int maxLen = 0;
    private List<String> newArr = new ArrayList<>();

    public int maxLength(List<String> arr) {
        List<Integer> longs = changeToBit(arr);
        dfs(longs, newArr, 0, 0, "");
        return maxLen;
    }

    private void dfs(List<Integer> longs, List<String> arr, int index, int val, String path) {
        if (index > longs.size())
            return;

        if (path.length() > maxLen)
            maxLen = path.length();

        for (int i = index; i < arr.size(); i++) {
            if ((val & longs.get(i)) != 0)
                continue;
            dfs(longs, arr, i + 1, val | longs.get(i), path + arr.get(i));
        }
    }

    public List<Integer> changeToBit(List<String> arr){
        List<Integer> list = new ArrayList<>();
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            int val = 0;
            char[] chars = arr.get(i).toCharArray();
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                int span = 1 << chars[j] - 'a';
                if (( span & val )!= 0) {
                    flag = false;
                    break;
                }
                val = val | 1 << (chars[j] - 'a');
            }
            if (flag) {
                list.add(val);
                newArr.add(arr.get(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("abac");
        int maxLength = new Problem1239().maxLength(list);
        System.out.println(maxLength);
    }
}
