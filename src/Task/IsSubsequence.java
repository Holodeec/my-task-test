package Task;

import java.util.Arrays;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty()) return true;
        if (s.length() > t.length()) return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int x = 0;

        for (int i = 0; i < b.length; i++) {
            if (a[x] == b[i]) {
                x++;
            }
            if (x == a.length) return true;
        }
        return false;
    }
}
