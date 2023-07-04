package Task;

public class Degree {
    public static boolean isPowerOf(int a, int b) {
        if (a == 0 && b == 0) {
            // Отдельный случай: 0 в степени 0 не определено
            return false;
        }

        if (a == 1 || b == 1) {
            // Любое число в степени 1 равно самому числу
            return true;
        }

        int power = b;
        while (power < a) {
            power *= b;
        }

        return power == a;
    }
}
