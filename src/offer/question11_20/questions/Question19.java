package offer.question11_20.questions;

public class Question19 {

    public boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null)
            return false;

        return func(str.toCharArray(), 0, pattern.toCharArray(), 0);
    }

    private boolean func(char[] str, int si, char[] pattern, int pi) {
        if (si == str.length && pi == pattern.length)
            return true;

        if (si < str.length && pi == pattern.length)
            return false;

        if (pi < pattern.length - 1 && pattern[pi + 1] == '*'){
            if (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')){
                return func(str, si + 1, pattern, pi)
                            || func(str, si, pattern, pi + 2);
            }else {
                return func(str, si, pattern, pi + 2);
            }
        }else {
            if (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.'))
                return func(str, si + 1, pattern, pi + 1);
            else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question19().isMatch("ba", ".*a*a"));
        System.out.println(new Question19().isMatch("a", "ab*"));
        System.out.println(new Question19().isMatch("", "*"));
        System.out.println(new Question19().isMatch("", "."));
        System.out.println(new Question19().isMatch("aaa", "a*ac*a"));
        System.out.println(new Question19().isMatch("aaa", "a*c*a"));
        System.out.println(new Question19().isMatch("mississippi", "mis*is*p*."));
        System.out.println(new Question19().isMatch("aab", "c*a*b"));
    }

}
