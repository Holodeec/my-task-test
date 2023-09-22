package Task;

import java.math.BigInteger;
import java.util.*;

public class IntegerArraysMethod {

    // todo Метод проверяет можно ли сумировав 2 ячейки массива получить значение sum
    public static boolean checkSum(int[] numbers, int sum) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if ((numbers[i] + numbers[i + 1]) == sum) {
                return true;
            }
        }
        return false;
    }

    // todo Метод проверяет можно ли сумировав 2 ячейки массива получить значение sum и возврашает индексы значений
    public static int[] checkSum1(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
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

    // todo Метод проверяет можно ли сумировав 2 ячейки массива получить значение sum и возврашает индексы значений
    public static int[] checkSum2(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] + nums[j - i] == target) {
                    return new int[]{j - i, j};
                }
            }
        }
        return null;
    }

    // todo Метод сортирует массив и проверяет есть ли дубликаты в нем
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // todo Метод принимает 2 массива, объединяет и сортирует. Массив nums[] имеет длину m + n. Переменные m и n это количество элементов в массиве
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
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

    // todo Проверка на палиндром
    public static boolean isPalindrome(int[] b) {
        int size = b.length;
        for (int i = 0; i < size / 2; i++) {
            if (b[i] != b[size - i - 1]) {
                return false;
            }
        }
        return true;
    }

    // todo Метод добавляет к огромному числу которое находится в массиве + 1
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
        if (s.length() > digits.length) {
            a = new int[digits.length + 1];
        }
        for (int i = 0; i < s.length(); i++) {
            a[i] = Character.getNumericValue(s.charAt(i));
        }
        return a;
    }

    // todo Метод добавляет к огромному числу которое находится в массиве + 1
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

    // todo Метод определяет количество уникальных чисел
    public static int amountUnique(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // todo Метод разворачивает массив от start до end; Пример 1.2.3.4.5 == 2.1.3.4.5
    public static void reverse(int[] nums, int start, int end) {
        while (end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        /*  public static void rotate(int[] nums, int k) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }*/
    }

    // todo Сортировка с права на лево или наоборот
    public static int[] flip(char dir, int[] arr) {
        int a;
        int length = arr.length;
        if (dir == 'L') {
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (arr[i] > arr[j]) {
                        a = arr[i];
                        arr[i] = arr[j];
                        arr[j] = a;
                    }
                }
            }
        } else if (dir == 'R') {
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (arr[i] < arr[j]) {
                        a = arr[j];
                        arr[j] = arr[i];
                        arr[i] = a;
                    }
                }
            }
        }
        return arr;
    }

    // todo Метод подсчета едениц в массивах когда они все в начале
    //  int[][]{
    //  {1,1,0,0,0}
    //  {1,0,0,0,0}
    //  {1,1,1,0,0}
    //  }
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

    // todo Используется методом kWeakestRows
    private static int countOnes(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num == 1) {
                count++;
            }
        }
        return count;
    }

    // todo Метод подсчета едениц в массивах когда они все в начале
    //  int[][]{
    //  {1,1,0,0,0}
    //  {1,0,0,0,0}
    //  {1,1,1,0,0}
    //  }
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
            list.add(new Tet(i, t));
        }
        return list.stream().sorted(Comparator.comparingInt(n -> n.value)).limit(k).mapToInt(n -> n.index).toArray();
    }

    // todo Метод определяет количество val значений в массиве
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    // todo Метод находит число в массиве если оно есть иначе индекс где оно может быть
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        while (index < nums.length && target > nums[index]) {
            index++;
        }
        return index;
    }

    public static int[] returnTwoIndex(int a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < b.length; i++) {

            int result = a - b[i];

            if (map.containsKey(result)) {
                index[0] = map.get(result);
                index[1] = i;
                break;
            }
            map.put(b[i], i);
        }

        return index;
    }
}

// todo Используется методом kWeakestRows1 для хранения значений и индекса
class Tet {
    int index;
    int value;

    public Tet(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
