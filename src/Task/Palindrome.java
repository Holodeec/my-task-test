package Task;

public class Palindrome {


    public static boolean isPalindrome(int...b) {
        int size = b.length;
        for (int i = 0; i < size / 2; i++) {
            if(b[i] != b[size - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String left = String.valueOf(stringBuilder);
        String right = String.valueOf(stringBuilder.reverse());

        return left.equals(right);
    }

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

    public static boolean isPalindromeString2(String s) {
        String str = s.replaceAll("\\p{Punct}|\\p{Space}", "").toLowerCase();

        int length = str.length() - 1;
        System.out.println(str);
        for (int i = 0; i <= length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }
}
