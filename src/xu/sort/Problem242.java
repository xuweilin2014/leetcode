package xu.sort;

public class Problem242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] str1 = new int[s.length()];
        int[] str2 = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            str1[i] = s.charAt(i) - 'a';
            str2[i] = t.charAt(i) - 'a';
        }
        sort(str1, 0, str1.length - 1);
        sort(str2, 0, str2.length - 1);
        int slow = 0, high = 0;
        while (slow < str1.length && high < str2.length){
            if (str1[slow] != str2[high])
                return false;
            slow++;
            high++;
        }

        return true;
    }

    private void sort(int[] arr, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = arr[begin];
            while (i < j){
                while (i < j && arr[j] > key)
                    j--;
                if (i < j){
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < key)
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
        System.out.println(new Problem242().isAnagram("ba", "ab"));
    }
}
