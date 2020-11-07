package xu.greedy;

public class Problem134 {

    private int length;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        this.length = gas.length;
        int sum = 0;
        int oilReserve = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
            oilReserve = oilReserve + gas[i] - cost[i];

            if (oilReserve < 0) {
                oilReserve = 0;
                start = getNext(i);
            }
        }

        if (sum < 0)
            return -1;
        else
            return start;
    }

    private int getNext(int index){
        return (index + 1) % this.length;
    }

    public static void main(String[] args) {
        System.out.println(new Problem134().canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Problem134().canCompleteCircuit(
                new int[]{2, 3, 4}, new int[]{3, 4, 3}));

    }

}
