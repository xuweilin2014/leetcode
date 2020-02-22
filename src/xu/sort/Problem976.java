package xu.sort;

public class Problem976 {
    public int largestPerimeter(int[] A) {
        sort(A, 0, A.length - 1);
        for (int i = 0; i < A.length - 2; i++) {
            if (isValid(A[i], A[i+1], A[i+2]))
                return A[i] + A[i+1] + A[i+2];
        }
        return 0;
    }

    private boolean isValid(int v1, int v2, int v3) {
        if (v1 + v2 > v3 && v1 + v3 > v2 && v2 + v3 > v1)
            return true;
        return false;
    }


    private void sort(int[] arr, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = arr[begin];
            while (i < j){
                while (i < j && arr[j] < key)
                    j--;
                if (i < j){
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] > key)
                    i++;
                if (i < j){
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = key;
            sort(arr, begin, i - 1);
            sort(arr, i + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem976().largestPerimeter(new int[]{3, 2,3,4}));
    }

}
