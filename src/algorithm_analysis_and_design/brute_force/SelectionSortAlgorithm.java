package algorithm_analysis_and_design.brute_force;

import java.util.List;

/**
 * 选择排序
 */
public class SelectionSortAlgorithm {

    public static void main(String[] args) {
        int[] array = selectionSort(new int[]{102,44,8,7,6,-1});
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }

            int tmp = arr[i];
            arr[i] = min;
            arr[index] = tmp;
        }

        return arr;
    }

}
