import Task.ArrayMerging;
import Task.Converter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[11];
        a[0] = 23;
        a[1] = 2;
        a[2] = 1;
        a[3] = 31;
        a[4] = 5;
        a[5] = 4;
        int[] b = {6,2,28,1,10};
        int[] x = ArrayMerging.merge(a,6,b,5);
        System.out.println(Arrays.toString(x));

    }
}