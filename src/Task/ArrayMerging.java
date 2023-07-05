package Task;

public class ArrayMerging {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i <= n -1; i++) {
            nums1[i + m ] = nums2[i];
        }
        return nums1;
    }
}
