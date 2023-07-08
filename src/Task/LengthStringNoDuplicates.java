package Task;


import java.util.HashSet;


public class LengthStringNoDuplicates {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
        }
        return set.size();
    }

    public static String[] splitStringIntoArray(String str) {
        String[] letters = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            letters[i] = String.valueOf(str.charAt(i));
        }
        return letters;
    }
}
