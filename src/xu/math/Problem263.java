package xu.math;

import xu.heap.Problem264;

public class Problem263 {
    public boolean isUgly(int num) {
        while (num % 2 == 0 && num != 0){
            num /= 2;
        }
        while (num % 3 == 0 && num != 0){
            num /= 3;
        }
        while (num % 5 == 0 && num != 0){
            num /= 5;
        }
        if (num == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem263().isUgly(14));
    }
}
