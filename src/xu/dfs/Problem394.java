package xu.dfs;

import java.util.Base64;
import java.util.Stack;

public class Problem394 {
    public String decodeString(String s) {
        if ("".equals(s))
            return "";

        Stack<String> vals = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (chars[i] == ']'){
                String str = vals.pop();
                int times = Integer.parseInt(vals.pop());
                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }
                char ch;
                while (!vals.isEmpty()){
                    ch = vals.peek().charAt(0);
                    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                        sb = new StringBuilder(vals.pop()).append(sb);
                    else
                        break;
                }
                vals.push(sb.toString());
            }else if (chars[i] >= '0' && chars[i] <= '9'){
                int j = i;
                while (chars[j] >= '0' && chars[j] <= '9'){
                    sb.append(chars[j++]);
                }
                i = j - 1;
                vals.push(sb.toString());
            }else if ((chars[i] >= 'a' && chars[i] <= 'z') ||
                    (chars[i] >= 'A' && chars[i] <= 'Z')){
                int j = i;
                while (j < chars.length && ((chars[j] >= 'a' && chars[j] <= 'z') ||
                        (chars[j] >= 'A' && chars[j] <= 'Z'))){
                    sb.append(chars[j++]);
                }
                char ch;
                while (!vals.isEmpty()){
                    ch = vals.peek().charAt(0);
                    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                        sb = new StringBuilder(vals.pop()).append(sb);
                    else
                        break;
                }
                i = j - 1;
                vals.push(sb.toString());
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Problem394().decodeString("2[abc]3[cd2[K]M]ef"));
    }
}
