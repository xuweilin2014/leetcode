package xu.heap;

/**
 * 丑数
 * 基本思想，此题有两种解法：
 * 第一种：第一种方法是蛮力法，也就是从从1开始遍历，如果是丑数则count加一，如果count等于k为止，直到count等于k为止。
 * 此方法得关键是如何判断一个数是丑数，考虑丑数只有2,3,5这三个因子，我们可以如下方法进行判断：
 *
 * 1.第一步，如果一个数能够被2整除，那么让他继续除以2
 * 2.第二步，如果一个数能够被3整除，那么让他继续除以3
 * 3.第三步，如果一个数能够被5整除，那么让他继续除以5
 * 4.第四步，如果这个数变为1，那么这个数就是丑数，否则不是。
 *
 * 第二种：如果已知了n个丑数，第n+1个丑数必然是前n个丑数中的某一个乘以2，或者乘以3，或者乘以5。至于具体是哪一个，
 * 则可以都尝试一下，然后去较小的那个
 */

public class Problem264 {
    public int nthUglyNumber(int n) {
        if (n <= 5)
            return n;

        int start1 = 0, start2 = 0, start3 = 0;
        int[] vals = new int[n];
        for (int i = 0; i < 5; i++) {
            vals[i] = i + 1;
        }
        int counter = 5;
        while (counter < n){
            //使用*2第一次超过已知的最大丑数 vals[count] 的
            for (int i = start1; i < counter; i++) {
                if (vals[i] * 2 > vals[counter-1]){
                    start1 = i;
                    break;
                }
            }
            //使用*3第一次超过已知的最大丑数 vals[count] 的
            for (int i = start2; i < counter; i++) {
                if (vals[i] * 3 > vals[counter-1]){
                    start2 = i;
                    break;
                }
            }
            //使用*5第一次超过已知的最大丑数 vals[count] 的
            for (int i = start3; i < counter; i++){
                if (vals[i] * 5 > vals[counter-1]){
                    start3 = i;
                    break;
                }
            }

            vals[counter++] = Math.min(Math.min(vals[start1]*2, vals[start2]*3)
                        , vals[start3]*5);
        }
        return vals[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem264().nthUglyNumber(1600));
    }
}
