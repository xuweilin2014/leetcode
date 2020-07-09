package algorithm_analysis_and_design.brute_force;

/**
 * 使用穷举法来求解子串匹配问题
 */
public class BFAlgorithm {

    public static void main(String[] args) {
        System.out.println(bf("abc".toCharArray(), "e".toCharArray()));
    }

    public static int bf(char[] target, char[] src){
        int i;
        for (i = 0; i < target.length; i++) {
            int j;
            int index = i;
            int counter = 0;
            for (j = 0; j < src.length; j++) {
                if (index < target.length && target[index++] == src[j])
                    counter++;
                else
                    break;
            }
            if (counter == src.length)
                return i;
        }
        return -1;
    }



}
