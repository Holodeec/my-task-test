package Task;

public class Sort {
    public static int[] flip(char dir, int[] arr) {
        int a;
        if(dir == 'L') {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if(arr[i] > arr[j]) {
                        a = arr[i];
                        arr[i] = arr[j];
                        arr[j] = a;
                    }
                }
            }

        }

        /*
        *if(dir == 'R') {
        *  for(int i = 0; i < arr.length; i++) {
        *       a = arr[i];
        *       arr[i] = arr[arr.length - i -1];
        *       arr[arr.length - i -1] = a;
        *   }
        * }
        */


        else if (dir == 'R') {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if(arr[i] < arr[j]) {
                        a = arr[j];
                        arr[j] = arr[i];
                        arr[i] = a;
                    }
                }
            }
        }
        return arr;
    }
}
