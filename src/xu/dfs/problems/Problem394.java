package xu.dfs.problems;

public class Problem394 {

    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";

        StringBuilder ans = new StringBuilder();
        func(s.toCharArray(), 0, ans);
        return ans.toString();
    }

    private int func(char[] chs, int index, StringBuilder ans) {
        if (index == chs.length)
            return index;

        int num = 0;
        int i;

        for (i = index; i < chs.length; i++) {
            if (chs[i] == '['){
                StringBuilder mid = new StringBuilder();
                // 返回的 i 是下一层中 ']' 字符的位置，mid 是下一层中 '[]' 符号中进行解码的结果
                i = func(chs, i + 1, mid);
                if (num > 0){
                    for (int j = 0; j < num; j++) {
                        ans.append(mid);
                    }
                }
                num = 0;
            // 如果是数字的话，就必须不断累积，因为有可能是大于 9 的数字
            }else if (chs[i] >= '0' && chs[i] <= '9'){
                num = num * 10 + chs[i] - '0';
            // 在 number[abc...xyz] 前后也有可能有字母，因此需要添加到 ans 中
            }else if (chs[i] >= 'a' && chs[i] <= 'z'){
                ans.append(chs[i]);
            }else if (chs[i] == ']'){
                break;
            }
        }

        // 返回的 i 要么是到了字符的末尾，要么是遇到了字符 ']'
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Problem394().decodeString("3[a]2[bc]"));
        System.out.println(new Problem394().decodeString("20[aa]"));
        System.out.println(new Problem394().decodeString("abc3[cd]xyz"));
        System.out.println(new Problem394().decodeString("2[ee3[a2[c]]f]"));
        System.out.println(new Problem394().decodeString("2[abc]3[cd2[k]m]ef"));
    }
}
