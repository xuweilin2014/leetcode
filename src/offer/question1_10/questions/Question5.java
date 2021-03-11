package offer.question1_10.questions;

public class Question5 {

    public static void main(String[] args) {
        System.out.println(new Question5().replaceSpace("we are happy."));
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ')
                sb.append("%20");
            else
                sb.append(ch);
        }

        return sb.toString();
    }

}
