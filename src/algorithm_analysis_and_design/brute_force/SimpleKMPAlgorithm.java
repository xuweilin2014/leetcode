package algorithm_analysis_and_design.brute_force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleKMPAlgorithm {

    public static void main(String[] args) {
        System.out.println(getNext("abababca".toCharArray()));
    }

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

}
