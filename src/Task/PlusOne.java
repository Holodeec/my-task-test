package Task;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne1(int[] digits) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            str = str.append(digits[i]);
        }
        String s = str.toString();
        BigInteger t = new BigInteger(s);
        t = t.add(BigInteger.ONE);
        s = t + "";
        int[] a = new int[s.length()];
        if(s.length() > digits.length) {
            a = new int[digits.length + 1];
        }
        for (int i = 0; i < s.length(); i++) {
            a[i] = Character.getNumericValue(s.charAt(i));
        }
        return a;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
