package xu.array;

public class Problem7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int sum = 0;
        long prev = 0;
        boolean isNegative = x < 0;
        x = isNegative ? -x : x;

        while (x > 0){
            prev = ((long) sum) * 10 + x % 10;
            sum = sum * 10 + x % 10;
            if (prev != sum)
                return 0;
            x = x /10;
        }

        if (isNegative)
            return -sum;

        return sum;
    }

}
