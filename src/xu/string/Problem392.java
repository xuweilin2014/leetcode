package xu.string;

public class Problem392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length())
            return false;

        int ps = 0;
        int pt = 0;

        while (ps < s.length() && pt < t.length()){
            if (s.charAt(ps) == t.charAt(pt)){
                ps++;
            }
            pt++;
        }

        return ps == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Problem392().isSubsequence("acb", "ahbgdc"));
        System.out.println(new Problem392().isSubsequence("axc", "anbgdc"));
        System.out.println(new Problem392().isSubsequence("abc", "anbgdc"));
    }

}
