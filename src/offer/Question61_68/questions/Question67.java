package offer.Question61_68.questions;

public class Question67 {

    public int strToInt(String str) {
        boolean positive = true;
        boolean sign = false;
        boolean numeric = false;
        char[] chs = str.toCharArray();
        double res = 0;

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' '){
                if (numeric)
                    break;
                continue;
            }

            if (chs[i] == '-' || chs[i] == '+') {
                if (sign || numeric)
                    break;

                sign = true;
                if (chs[i] == '-') positive = false;
                if (i + 1 < chs.length && !Character.isDigit(chs[i + 1]))
                    break;
                continue;
            }

            if (!Character.isDigit(chs[i])){
                break;
            }

            res = res * 10 + chs[i] - '0';
            numeric = true;
        }

        res = positive ? res : -res;

        if (res >= Integer.MAX_VALUE)
            res = Integer.MAX_VALUE;
        if (res <= Integer.MIN_VALUE)
            res = Integer.MIN_VALUE;

        return (int) res;
    }

    // 涵盖了各种 corner case 的测试用例
    public static void main(String[] args) {
        System.out.println(new Question67().strToInt("-91283472332"));
        System.out.println(new Question67().strToInt(" +213 432424"));
        System.out.println(new Question67().strToInt("-+2"));
        System.out.println(new Question67().strToInt(" +0 123"));
        System.out.println(new Question67().strToInt("9223372036854775808"));
        System.out.println(new Question67().strToInt("0-1"));
        System.out.println(new Question67().strToInt("-13+8"));
        System.out.println(new Question67().strToInt(" +   +  -2"));
    }

}
