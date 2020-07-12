package xu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于一个形如 x op y（op 为运算符，x 和 y 为数） 的算式而言，它的结果组合取决于 x 和 y 的结果组合数
 * 因此，该问题的子问题就是 x op y 中的 x 和 y：以运算符分隔的左右两侧算式解。
 *
 * 然后我们来进行分治算法三步走：
 *
 * 分解：按运算符分成左右两部分，分别求解
 * 解决：实现一个递归函数，输入算式，返回算式解的集合
 * 合并：根据运算符组合左右两部分的解，得出最终解的集合
 *
 */
public class Problem241 {

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        if (!input.contains("*") && !input.contains("+") &&
                !input.contains("-")){
            res.add(Integer.parseInt(input));
            return res;
        }

        List<Integer> ops = getOpIndex(input.toCharArray());
        for (int op : ops) {
            List<Integer> lres = diffWaysToCompute(input.substring(0, op));
            List<Integer> rres = diffWaysToCompute(input.substring(op + 1));

            for (Integer lval : lres) {
                for (Integer rval : rres) {
                    if (input.charAt(op) == '+')
                        res.add(lval + rval);
                    else if (input.charAt(op) == '*')
                        res.add(lval * rval);
                    else if (input.charAt(op) == '-')
                        res.add(lval - rval);
                }
            }
        }

        return res;
    }

    public static List<Integer> getOpIndex(char[] input){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i] >= '0' && input[i] <= '9')
                continue;

            list.add(i);
        }

        return list;
    }

}
