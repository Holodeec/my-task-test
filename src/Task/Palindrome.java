package Task;

public class Palindrome {


    public static boolean isPalindrome(int...b) {
        int size = b.length;
        int j = size-1;
        for (int i = 0; i < size / 2; i++) {

            if(b[i] == b[j]) {
                return false;
            }
            j--;
        }

        return true;
    }
}
