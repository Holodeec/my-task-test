import Task.ArrayMerging;
import Task.Converter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[11];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        a[4] = 4;
        a[5] = 5;
        int[] b = {6,7,8,9,10};
        int[] x = ArrayMerging.merge(a,6,b,5);
        System.out.println(Arrays.toString(x));

    }
}