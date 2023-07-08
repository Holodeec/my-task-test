package Task;

import java.util.Arrays;

public class ReverseString {

    public static void reverseString(char[] s) {
        String x = String.valueOf(s);
        for (int i = 0; i < s.length; i++) {
            s[i] = x.charAt(x.length() - i -1);
        }
    }
}
