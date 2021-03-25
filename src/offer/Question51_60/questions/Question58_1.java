package offer.Question51_60.questions;

/**
 * 翻转两次，第一次对字符串全体进行翻转，第二次对字符串中的每一个单词进行翻转
 */
public class Question58_1 {

    public String reverseWords(String s) {
        if (s == null)
            return null;

        s = s.trim();
        StringBuilder sb = new StringBuilder();
        boolean space = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (space) {
                    sb.append(s.charAt(i));
                    space = false;
                }
                continue;
            }

            sb.append(s.charAt(i));
            space = true;
        }

        char[] chs = sb.toString().toCharArray();
        doReverse(chs, 0, chs.length - 1);

        for (int i = 0; i < chs.length; i++) {
            int low = i;
            while (i < chs.length && chs[i] != ' ')
                i++;
            int high = i;
            doReverse(chs, low, high - 1);
        }

        return new String(chs);
    }

    private void doReverse(char[] chs, int low, int high){
        while (low < high){
            char temp = chs[low];
            chs[low] = chs[high];
            chs[high] = temp;

            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question58_1().reverseWords("  Bob    Loves  Alice   "));
    }

}
