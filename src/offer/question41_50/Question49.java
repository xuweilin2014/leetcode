package offer.question41_50;

import java.util.*;

public class Question49 {

    private static List<Integer> arr = new ArrayList<>();

    public static int nthUglyNumber(int n) {
        arr.add(1);
        arr.add(2);
        arr.add(3);

        if (n <= 3)
            return arr.get(n - 1);

        int p2 = 1;
        int p3 = 1;
        int p5 = 0;
        int peek = 2;

        for (int i = 3; i < n; i++) {
            if (arr.get(p2).equals(arr.get(peek) / 2))
                p2++;
            if (arr.get(p3).equals(arr.get(peek) / 3))
                p3++;
            if (arr.get(p5).equals(arr.get(peek) / 5))
                p5++;

            if (arr.get(p2) * 2 < arr.get(p3) * 3){
                if (arr.get(p2) * 2 < arr.get(p5) * 5){
                    arr.add(arr.get(p2) * 2);
                    p2++;
                }else{
                    arr.add(arr.get(p5) * 5);
                    p5++;
                }
            }else {
                if (arr.get(p3) * 3 < arr.get(p5) * 5){
                    arr.add(arr.get(p3) * 3);
                    p3++;
                }else{
                    arr.add(arr.get(p5) * 5);
                    p5++;
                }
            }
            peek++;
        }

        return arr.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(Question49.nthUglyNumber(11));
    }

}
