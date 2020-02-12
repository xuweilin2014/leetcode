package xu.backtracking;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1291 {

    private long low, high;
    private List<Integer> res = new ArrayList<>();

    public List<Integer> sequentialDigits(int low, int high) {
        this.low = low;
        this.high = high;
        for (int i = 1; i <= 9; i++) {
            dfs(i, 0);
        }
        Collections.sort(res);
        return res;
    }

    private void dfs(int digit, int sum) {
        if (sum >= low && sum <= high)
            res.add(sum);

        if (sum > high || digit > 9)
            return;

        sum = sum * 10 + digit;
        dfs(digit + 1, sum);
    }

    public static void main(String[] args) {
        List<Integer> list = new Problem1291().sequentialDigits(1000, 3000);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }

}
