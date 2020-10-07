package offer.Question51_60;

/**
 * 将待旋转的字符串分为 2 部分，分别进行翻转，一共翻转 3 次
 */
public class Question58_2 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0)
            return s;

        char[] chs = s.toCharArray();
        doReverse(chs, 0, n - 1);
        doReverse(chs, n, chs.length - 1);
        doReverse(chs, 0, chs.length - 1);

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
        System.out.println(new Question58_2().reverseLeftWords("lrloseumgh", 6));
    }

}
