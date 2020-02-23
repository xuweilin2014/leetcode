package xu.sort;

public class Problem274 {
    public int hIndex(int[] citations) {
        sort(citations, 0, citations.length - 1);
        int hindex = 1;
        int k = 0;
        while (k < citations.length){
            if (citations[k] >= hindex){
                hindex++;
                k++;
            }else{
                break;
            }
        }
        return hindex - 1;
    }

    private void sort(int[] citations, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = citations[begin];
            while (i < j){
                while (i < j && citations[j] < key)
                    j--;
                if (i < j){
                    citations[i] = citations[j];
                    i++;
                }
                while (i < j && citations[i] > key)
                    i++;
                if (i < j){
                    citations[j] = citations[i];
                    j--;
                }
            }
            citations[i] = key;
            sort(citations, begin, i - 1);
            sort(citations, i + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem274().hIndex(new int[]{0, 1, 4, 5, 6}));
    }
}
