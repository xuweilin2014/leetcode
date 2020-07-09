package algorithm_analysis_and_design.brute_force;

/**
 * 冒泡排序
 */
public class BubbleSortAlgorithm {

    public static void main(String[] args) {
        int[] arr = bubbleSort(new int[]{102,-8,7,7,6,-1});
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] bubbleSort(int[] arr){
        if (arr == null || arr.length == 0 || arr.length == 1)
            return arr;

        int exchange = arr.length - 1;
        int bound;

        while (exchange != 0){
            bound = exchange;
            exchange = 0;
            for (int i = 0; i < bound; i++) {
                if (arr[i] > arr[i + 1]){
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    exchange = i;
                }
            }
        }

        return arr;
    }

}
