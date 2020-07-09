package algorithm_analysis_and_design.brute_force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * KMP字符串匹配算法（暴力求解next数组）
 */
public class SimpleKMPAlgorithm {

    public static void main(String[] args) {
        System.out.println(KMP("mississippi".toCharArray(), "issip".toCharArray()));
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
        List<Integer> nexts = getNext(target);
        int j = 0, i = 0;
        while (i < src.length && j < target.length){
            if (src[i] == target[j]){
                i++;
                j++;
            }else{
                j = nexts.get(j);
                if (j == -1){
                    i++;
                    j++;
                }
            }
        }
        if (j == target.length)
            return i - target.length;
        else
            return -1;
    }

}
