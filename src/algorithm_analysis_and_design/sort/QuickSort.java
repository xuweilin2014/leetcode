package algorithm_analysis_and_design.sort;

public class QuickSort {

    private int[] arr;

    public QuickSort(int[] array){
        this.arr = array;
    }

    public void sort(){
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int i = begin;
            int j = end;
            int key = arr[begin];
            while (i < j) {
                while (i < j && arr[j] > key)
                    j--;
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < key) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = key;
            quickSort(arr, begin, i - 1);
            quickSort(arr, i + 1, end);
        }
    }

    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort(new int[]{5, 9, 1, 9, 5, 3, 7, 6, 1});
        sort.sort();
        sort.print();
    }

}
