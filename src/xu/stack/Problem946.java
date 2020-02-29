package xu.stack;

import java.util.Stack;

public class Problem946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (j < popped.length){
            if (stack.isEmpty()){
                stack.push(pushed[i++]);
            }else{
                if (stack.peek() == popped[j]){
                    stack.pop();
                }else{
                    if (i >= popped.length)
                        return false;
                    while (i < pushed.length && pushed[i] != popped[j])
                        stack.push(pushed[i++]);
                    i++;
                }
                j++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem946()
                .validateStackSequences(new int[]{8,9,2,3,7,0,5,4,6,1},
                new int[]{6,8,2,1,3,9,0,7,4,5}));
    }
}
