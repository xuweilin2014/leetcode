package offer.Question51_60;

public class Question58_2 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0)
            return s;

        StringBuilder before = new StringBuilder();
        StringBuilder after = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (i < n)
                before.append(chs[i]);
            else
                after.append(chs[i]);
        }

        return after.append(before).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Question58_2().reverseLeftWords("lrloseumgh", 6));
    }

}
