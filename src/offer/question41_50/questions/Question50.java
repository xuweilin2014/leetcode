package offer.question41_50.questions;

import java.util.*;

public class Question50 {

    public int FirstNotRepeatingChar(String str) {
        int[] indices = new int[52];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                indices[ch - 'a']++;
            if (ch >= 'A' && ch <= 'Z')
                indices[ch - 'A' + 26]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z'){
                if (indices[ch - 'a'] == 1){
                    return i;
                }
            }
            if (ch >= 'A' && ch <= 'Z'){
                if (indices[ch - 'A' + 26] == 1){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Question50().FirstNotRepeatingChar("abaccdefbf"));
    }

}
