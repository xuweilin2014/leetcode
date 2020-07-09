package algorithm_analysis_and_design.brute_force;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用递归的方法求得next数组
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        System.out.println(kmp("abaababc".toCharArray(), "aab".toCharArray()));
    }

    public static List<Integer> getNexts(char[] target){
        int k = -1;
        List<Integer> arr = new ArrayList<>();
        arr.add(-1);
        int j = 1;
        while (j < target.length){
            if (k == -1){
                arr.add(0);
                k = 0;
                j++;
            }else if (target[j - 1] == target[k]){
                arr.add(k + 1);
                k++;
                j++;
            }else{
                k = arr.get(k);
            }
        }

        return arr;
    }

    public static int kmp(char[] src, char[] target){
        List<Integer> nexts = getNexts(target);
        int i = 0, j = 0;
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
        return -1;
    }

}
