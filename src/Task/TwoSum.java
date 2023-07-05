package Task;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for(int i = 0 ; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return a;
    }

    public static int[] two(int[] nums, int target) {
        for(int i = 1 ; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] + nums[j-i] == target) {
                    return new int[] {j-i,j};
                }
            }
        }
        return null;
    }
}
