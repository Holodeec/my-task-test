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
}
