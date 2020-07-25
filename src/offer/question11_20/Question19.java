package offer.question11_20;

/**
 * 正则表达式匹配
 */
public class Question19 {

    public static void main(String[] args) {
        System.out.println(match("".toCharArray(), ".".toCharArray()));
    }

    public static boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null ){
            return false;
        }

        return matchCore(str, pattern, 0, 0);
    }

    private static boolean matchCore(char[] str, char[] pattern, int pstr, int ppattern) {

        if (ppattern == pattern.length && pstr == str.length)
            return true;

        if (ppattern == pattern.length && pstr < str.length)
            return false;

        // 如果下一个字符是'*'
        if (ppattern + 1 < pattern.length && pattern[ppattern + 1] == '*'){
            // 当模式字符串和原始字符串对应的字符匹配时，有两种情况
            if (pstr < str.length && (str[pstr] == pattern[ppattern]
                    || pattern[ppattern] == '.')){
                boolean s1 = matchCore(str, pattern, pstr + 1, ppattern);
                boolean s2 = matchCore(str, pattern, pstr, ppattern + 2);
                return s1 || s2;

            // 当模式字符串和原始字符串不匹配时，有一种情况
            }else{
                return matchCore(str, pattern, pstr, ppattern + 2);
            }

        // 如果下一个字符不是'*'
        }else{
            // 当模式字符串和原始字符串对应的字符匹配时，两个指针都向后移动
            if (pstr < str.length && (str[pstr] == pattern[ppattern]
                    || pattern[ppattern] == '.')){
                return matchCore(str, pattern, pstr + 1, ppattern + 1);

            // 当模式字符串和原始字符串不匹配时，直接返回false，表示不匹配
            }else {
                return false;
            }
        }

    }

}
