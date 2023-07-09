package Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StringMethod {

    // todo Метод проверяет можно ли из одного слова создать другое используя буквы только 1 раз
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] first = ransomNote.toLowerCase().toCharArray();
        char[] last = magazine.toLowerCase().toCharArray();
        int l = last.length - first.length;
        List<Character> list = new ArrayList<>();

        for (char c : last) {
            list.add(c);
        }

        for (char c : first) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == c) {
                    list.remove(j);
                    break;
                }
            }
        }
        return list.size() == l;
    }

    // todo Метод проверяет можно ли из одного слова создать другое используя буквы только 1 раз
    public static boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i)))
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            else map.put(magazine.charAt(i), 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) > 0) {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            } else return false;
        }

        return true;
    }

    // todo Метод конвертации римских чисел в Арабские.
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int length = s.length() - 1;
        char[] arr = s.toCharArray();
        int mass, a = map.get(arr[length]);

        for (int i = length - 1; i >= 0; i--) {
            mass = map.get(arr[i]);

            if (mass < map.get(arr[i + 1])) {
                a -= mass;
            } else {
                a += mass;
            }
        }
        return a;
    }

    // todo Метод проверяет имеет ли переменная t буквы из s в таком же порядке
    //  например s = "abc" t = "agbpc" == true
    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
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

    // todo Метод возвращает длину последьнего слова
    public static int lengthOfLastWord(String s) {
        String[] text = s.split(" ");
        return text[text.length - 1].length();
    }

    // todo Метод определяет количесвво уникальных элементов в строке
    public static int lengthOfLongestSubstring(String s) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
        }
        return set.size();
    }

    // todo Метод разбивает строку по буквам и сохраняет в массив
    public static String[] splitStringIntoArray(String str) {
        String[] letters = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            letters[i] = String.valueOf(str.charAt(i));
        }
        return letters;
    }

    // todo Проверка строки на палиндром
    public static boolean isPalindromeString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String left = String.valueOf(stringBuilder);
        String right = String.valueOf(stringBuilder.reverse());

        return left.equals(right);
    }

    // todo Проверка строки на палиндром
    public static boolean isPalindromeString1(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // todo Проверка строки на палиндром
    public static boolean isPalindromeString2(String s) {
        String str = s.replaceAll("\\p{Punct}|\\p{Space}", "").toLowerCase();

        int length = str.length() - 1;
        System.out.println(str);
        for (int i = 0; i <= (length - 1) / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }


}
