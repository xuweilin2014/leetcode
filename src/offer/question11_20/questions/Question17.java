package offer.question11_20.questions;

// 考虑大数问题
public class Question17 {

    public static void main(String[] args) {
        printToMaxOfNDigitsRecursively(2);
    }

    // 常规解法
    public static void printToMaxOfNDigits(int n) {
        StringBuilder res = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            res.append("0");
        }

        int i = res.length() - 1;

        // 在加1的时候，第一个字符产生了进位，才说明已经是最大的n位数
        while (i >= 0){
            for (i = res.length() - 1; i >= 0; i--) {
                int val = res.charAt(i) - '0';
                if (++val > 9){
                    res.setCharAt(i, '0');
                }else{
                    res.setCharAt(i, (char) (val + '0'));
                    break;
                }
            }

            if (i >= 0)
                System.out.println(res);
        }

    }

    // 使用递归来求解全排列
    public static void printToMaxOfNDigitsRecursively(int n){
        doPrint(n, "");
    }

    public static void doPrint(int n, String res){
        if (n == 0) {
            if (Integer.parseInt(res) != 0)
                System.out.println(res);
            return;
        }

        for (int i = 0; i < 10; i++) {
            doPrint(n - 1, res + i);
        }
    }

}
