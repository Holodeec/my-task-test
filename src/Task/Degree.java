package Task;

public class Degree {

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
}
