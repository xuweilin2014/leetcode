package xu.string;

public class Problem14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length == 0)
            return prefix.toString();

        int minLen = Integer.MAX_VALUE;
        int counter = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen)
                minLen = strs[i].length();
        }

        while (counter < minLen){
            for (int i = 0; i < strs.length; i++) {
                if (i > 0 && strs[i].charAt(counter) != strs[i-1].charAt(counter))
                    return prefix.toString();
            }

            prefix.append(strs[0].charAt(counter++));
        }

        return prefix.toString();
    }

}
