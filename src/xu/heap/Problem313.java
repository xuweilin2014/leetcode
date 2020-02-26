package xu.heap;

import java.util.*;

public class Problem313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] vals = new int[n];
        int[] index = new int[primes.length];
        vals[0] = 1;
        int counter = 1;
        while (counter < n){
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < index.length; i++) {
                if (min > primes[i] * vals[index[i]])
                    min = primes[i] * vals[index[i]];
            }
            vals[counter++] = min;
            for (int i = 0; i < index.length; i++) {
                if (vals[index[i]] * primes[i] == min)
                    index[i]++;
            }
        }
        return vals[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem313()
                .nthSuperUglyNumber(1600, new int[]{2,3,5}));
    }
}
