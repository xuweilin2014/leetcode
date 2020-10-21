package xu.sort;


public class Problem922 {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        while (even < A.length && odd < A.length){
            while (even < A.length && A[even] % 2 == 0){
                even += 2;
            }
            while (odd < A.length && A[odd] % 2 != 0){
                odd += 2;
            }
            if (even < A.length && odd < A.length){
                int tmp = A[even];
                A[even] = A[odd];
                A[odd] = tmp;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        int[] ints = new Problem922().sortArrayByParityII(new int[]{4, 2, 5, 7});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
