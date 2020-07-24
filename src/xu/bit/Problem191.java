package xu.bit;

public class Problem191 {

    public int hammingWeight(int n) {
        if (n == 0 || n == 1)
            return n;

        int counter = 0;
        int mask = 1;
        int times = 1;
        while (times <= 32){
            if ((n & mask) == mask) {
                counter++;
            }
            mask = mask << 1;
            times++;
        }

        return counter;
    }

}
