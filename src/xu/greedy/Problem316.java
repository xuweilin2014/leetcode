package xu.greedy;

import java.util.*;

public class Problem316 {

    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];

        for (char ch : s.toCharArray()) {
            counter[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            counter[ch - 'a']--;
            if (stack.contains(ch))
                continue;

            while (!stack.isEmpty() && stack.peek() > ch) {
                if (counter[stack.peek() - 'a'] <= 0)
                    break;
                stack.pop();
            }

            stack.push(ch);
        }

        Collections.reverse(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem316().removeDuplicateLetters("bcabc"));
        System.out.println(new Problem316().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Problem316().removeDuplicateLetters("leetcode"));
        System.out.println(new Problem316().removeDuplicateLetters("cdadabcc"));
        System.out.println(new Problem316().removeDuplicateLetters("bbcaac"));
    }

}
