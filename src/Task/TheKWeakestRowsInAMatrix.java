package Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TheKWeakestRowsInAMatrix {

    public static int[] kWeakestRows(int[][] mass, int k) {
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < mass.length; i++) {
            indexList.add(i);
        }

        return indexList.stream()
                .sorted(Comparator.comparingInt(n -> countOnes(mass[n])))
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();
    }
    private static int countOnes(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num == 1) {
                count++;
            }
        }
        return count;
    }

    public static int[] kWeakestRows1(int[][] mat, int k) {
        int[] arr = new int[mat.length];
        List<Tet> list = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int t = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    t++;
                }
            }
            arr[i] = t;
            list.add(new Tet(i,t));
        }
        return list.stream().sorted(Comparator.comparingInt(n -> n.value)).limit(k).mapToInt(n -> n.index).toArray();
    }
}

class Tet {
    int index;
    int value;

    public Tet(int index, int value) {
        this.index = index;
        this.value = value;
    }
}