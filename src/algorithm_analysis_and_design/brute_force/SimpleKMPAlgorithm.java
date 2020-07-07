package algorithm_analysis_and_design.brute_force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * KMP字符串匹配算法（暴力求解next数组）
 */
public class SimpleKMPAlgorithm {

    public static void main(String[] args) {
        System.out.println(KMP("abcabcacb".toCharArray(), "z".toCharArray()));
    }

    // 获取模式字符串的next数组
    public static List<Integer> getNext(char[] src){
        List<Integer> nexts = new ArrayList<>();
        nexts.add(-1);
        for (int j = 1; j < src.length; j++) {
            int max = 0;
            for (int k = 1; k < j; k++) {
                int i = 0, m = j - k;
                int counter = k;
                while (counter > 0){
                    if (src[i++] != src[m++])
                        break;
                    counter--;
                }

                if (counter == 0){
                    max = k;
                }
            }
            nexts.add(max);
        }
        return nexts;
    }

    public static int KMP(char[] src, char[] target){
        List<Integer> nexts = getNext(src);
        int j = 0, i;
        boolean isMatch = false;
        for (i = 0; i < src.length;) {
            while (j < target.length){
                if (src[i] == target[j]){
                    i++;
                    j++;
                }else
                    break;
            }

            if (j == target.length){
                isMatch = true;
                break;
            }else{
                j = nexts.get(j);
                if (j == -1){
                    i++;
                    j++;
                }
            }
        }
        return isMatch ? i - target.length : -1;
    }

}
