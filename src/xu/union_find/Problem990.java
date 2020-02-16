package xu.union_find;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem990 {
    public boolean equationsPossible(String[] equations) {
        List<String> noequal = new ArrayList<>();
        List<String> equal = new ArrayList<>();
        for (String equation : equations) {
            if (equation.contains("!"))
                noequal.add(equation);
            else
                equal.add(equation);
        }
        UnionFind uf = new UnionFind(26);
        for (String equation : equal) {
            uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }

        for (String equation : noequal) {
            int v1 = equation.charAt(0) - 'a';
            int v2 = equation.charAt(3) - 'a';
            if (uf.find(v1) == uf.find(v2))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem990().equationsPossible(new String[]{
                "a==b","b!=c","c==a"
        }));
    }
}
