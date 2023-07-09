package Task;

import java.util.Arrays;

public class StringArraysMethod {


    // todo Метод проверяет сколько начальных одинаковых букв у слов в массиве и выводит их.
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    // todo Метод разворачивает массив
    public static void reverseString(char[] s) {
        String x = String.valueOf(s);
        for (int i = 0; i < s.length; i++) {
            s[i] = x.charAt(x.length() - i - 1);
        }
    }
}
