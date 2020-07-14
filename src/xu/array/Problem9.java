package xu.array;

public class Problem9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int val = 0;
        int tmp = x;
        while (x > 0){
            val = val * 10 + x % 10;
            x = x / 10;
        }

        return val == tmp;
    }

}
