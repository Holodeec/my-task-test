package Task;

public class ArrayMerging {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i <= n - 1; i++) {
            nums1[i + m] = nums2[i];
        }

        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums1.length - 1; j++) {
                int a = nums1[i];

                if (nums1[i] < nums1[j]) {
                    nums1[i] = nums1[j];
                    nums1[j] = a;
                }
            }
        }
        return nums1;
    }
}
