package Task;

public class CheckSum {

    public static boolean checkSum(int[] numbers, int sum) {
        for(int i = 0; i < numbers.length-1 ; i++) {
            if ((numbers[i] + numbers[i + 1]) == sum) {
                return true;
            }
        }
        return false;
    }
}
