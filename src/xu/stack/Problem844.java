package xu.stack;

import java.util.Stack;

public class Problem844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> line = new Stack<>();
        updateStack(line, S);
        StringBuilder sb1 = new StringBuilder();
        stackToString(line, sb1);
        line.clear();
        updateStack(line, T);
        StringBuilder sb2 = new StringBuilder();
        stackToString(line, sb2);
        return sb1.toString().equals(sb2.toString());
    }

    private void updateStack(Stack<Character> line, String s){
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!line.isEmpty())
                    line.pop();
            }
            else
                line.push(c);
        }
    }

    private void stackToString(Stack<Character> line, StringBuilder sb) {
        while (!line.isEmpty()){
            sb.append(line.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem844().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
