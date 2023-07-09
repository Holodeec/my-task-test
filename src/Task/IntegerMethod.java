package Task;

public class IntegerMethod {

    // todo Метод проверяет является ли b в определенной степени равной a.
    public static boolean isPowerOf(int a, int b) {
        if (a == 0 && b == 0) {
            return false;
        }

        if (a == 1 || b == 1) {
            return true;
        }

        int power = b;
        while (power < a) {
            power *= b;
        }
        return power == a;
    }

    // todo Проверка на палиндром
    public boolean isPalindrome(int x) {
        String pall = x + "";
        char[] array = pall.toCharArray();
        int leng = array.length;

        for (int i = 0; i <= leng / 2; i++) {
            if (array[i] != array[leng - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
