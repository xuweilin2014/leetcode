package xu.sort;

import java.util.ArrayList;
import java.util.List;

public class Problem1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2){
        int[] ctn = new int[10001];
        int k = 0;
        for (int val : arr1) ctn[val]++;
        for (int i = 0; i < arr2.length; i++) {
            while (ctn[arr2[i]] > 0){
                arr1[k++] = arr2[i];
                ctn[arr2[i]]--;
            }
        }

        for (int i = 0; i < ctn.length; i++) {
            while (ctn[i] > 0) {
                arr1[k++] = i;
                ctn[i]--;
            }
        }

        return arr1;
    }

    public int[] solution1(int[] arr1, int[] arr2) {
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            array.add(arr2[i]);
        }

        boolean flag = true;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i])
                    array2.add(arr1[j]);
                if (!array.contains(arr1[j]) && flag){
                    array1.add(arr1[j]);
                }
            }
            flag = false;
        }

        sort(array1, 0, array1.size() - 1);
        int[] arr = new int[array2.size() + array1.size()];
        for (int i = 0; i < arr.length; i++) {
            if (i < array2.size())
                arr[i] = array2.get(i);
            else if (i - array2.size() < array1.size())
                arr[i] = array1.get(i - array2.size());
        }

        return arr;
    }

    public void sort(List<Integer> arr, int begin, int end){
        if (begin < end){
            int i = begin;
            int j = end;
            int key = arr.get(begin);
            while (i < j){
                while (i < j && arr.get(j) > key)
                    j--;
                if (i < j){
                    arr.set(i, arr.get(j));
                    i++;
                }
                while (i < j && arr.get(i) < key)
                    i++;
                if (i < j){
                    arr.set(j, arr.get(i));
                    j--;
                }
            }
            arr.set(i, key);
            sort(arr, begin,  i - 1);
            sort(arr, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] ints = new Problem1122().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},
                new int[]{2,1,4,3,9,6});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
