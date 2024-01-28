import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class Test {
    public Test() {
        super();
    }


    public void reg() throws Exception {
        throw new Exception();

    }

//    public static int[][] average() {
//        int[][] arr1 = {{1, 3, 5, 7, 12}, {5, 3, 7, 2, 3}, {12, 54, 2, 6, 7}};
//
//
//        for (int[] value : arr1) {
//            for (int i = 0; i < value.length; i++) {
//                int save;
//                for (int j = i + 1; j < value.length; j++) {
//                    if (value[j] < value[i]) {
//                        save = value[j];
//                        value[j] = value[i];
//                        value[i] = save;
//                    }
//                }
//            }
//        }
//        int[] average = new int[arr1.length];
//        int index = 0;
//        for (var arr : arr1) {
//            average[index++] = arr[arr.length - 1];
//        }
//        System.out.println(Arrays.deepToString(arr1));
//        System.out.println(Arrays.toString(average));
//        return arr1;
//
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j =0;j < arr[i].length;j++) {
//                if ((j == 0 && arr[i][j] == 1) || arr[i][j] == 1 && arr[i][j - 1] != 1) {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
//    }


    /**
     * Средние значения в массивах
     */
    public static void middleValueInArray() {
        int[][] arr1 = {{1, 3, 5, 7, 12}, {5, 3, 7, 2, 3}, {12, 54, 2, 6, 7}};

        for (int[] value : arr1) {
            int[] ints = Arrays.stream(value).sorted().limit(value.length / 2).toArray();
            System.out.println(ints);
        }
    }

    /**
     * Сумма всех элементов массива
     */
    public static void sumArray() {
        int[][] arr1 = {{1, 3, 5, 7, 12}, {5, 3, 7, 2, 3}, {12, 54, 2, 6, 7}};

        int sum = Arrays.stream(arr1).flatMapToInt(Arrays::stream).boxed().reduce(Integer::sum).get();
        System.out.println(sum);
    }

    /**
     * Убираем дубликаты из двумерного массива
     */
    public static void uniqueArray() {
        int[][] arr1 = {{1, 3, 5, 7, 12}, {5, 3, 7, 2, 3}, {12, 54, 2, 6, 7}};
        int[] arr2 = Arrays.stream(arr1).flatMapToInt(Arrays::stream).distinct().toArray();
        System.out.println(arr2);
    }

    /**
     * убираем дубликаты и сливаем два массива в один
     */
    public static void arrayUniqueWithSort() {
        int[] arr1 = {1, 2, 2, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6, 20};

        //int[] arr3 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().sorted().toArray();
        //System.out.println(arr3);

        int[] a = new int[arr1.length + arr2.length];
        int i = 0, a1 = 0, a2 = 0;

        while (a1 < arr1.length && a2 < arr2.length && i < a.length) {

            if (arr1[a1] < arr2[a2]) {
                while (a1 < arr1.length && arr1[a1] < arr2[a2]) {
                    a[i++] = arr1[a1++];
                }
            } else if (arr2[a2] < arr1[a1]) {
                while (a2 < arr2.length && arr2[a2] < arr1[a1]) {
                    a[i++] = arr2[a2++];
                }
            } else {
                while (arr1[a1] == arr2[a2]) {
                    a[i++] = arr1[a1++];
                    a2++;
                }

            }

        }


        System.out.println(Arrays.toString(a));
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int a_index = 0, b_index = 0, index = 0;

        while (a_index < arr1.length && b_index < arr2.length) {

            if (arr1[a_index] < arr2[b_index]) {
                if (a_index == 0 || arr1[a_index] != arr1[a_index - 1]) {
                    merged[index++] = arr1[a_index];
                }
                a_index++;
            } else if (arr1[a_index] > arr2[b_index]) {
                if (b_index == 0 || arr2[b_index] != arr2[b_index - 1]) {
                    merged[index++] = arr2[b_index];
                }
                b_index++;
            } else {
                if ((a_index == 0 || arr1[a_index] != arr1[a_index - 1]) && (b_index == 0 || arr2[b_index] != arr2[b_index - 1])) {
                    merged[index++] = arr1[a_index];
                }
                a_index++;
                b_index++;
            }
        }

        while (a_index < arr1.length) {
            if (a_index == 0 || arr1[a_index] != arr1[a_index - 1]) {
                merged[index++] = arr1[a_index];
            }
            a_index++;
        }

        while (b_index < arr2.length) {
            if (b_index == 0 || arr2[b_index] != arr2[b_index - 1]) {
                merged[index++] = arr2[b_index];
            }
            b_index++;
        }

        return merged;
    }

    public static String groupNumbers1(String input) {
        String[] values = input.split(",");
        StringBuilder build = new StringBuilder();
        int prev = Integer.parseInt(values[0]);

        build.append("(").append(prev);

        for (int i = 1; i < values.length; i++) {
            int x = Integer.parseInt(values[i]);

            if (x != prev + 1) {

                build.append(") (").append(x);
            } else {
                build.append(",").append(x);
            }

            prev = x;

        }
        build.append(")");
        return build.toString();
    }

    public static String groupNumbers(String input) {
        String[] numbers = input.split(",");
        StringBuilder sb = new StringBuilder();
        int start = Integer.parseInt(numbers[0]);
        int prev = start;

        sb.append("(").append(start);

        for (int i = 1; i < numbers.length; i++) {
            int current = Integer.parseInt(numbers[i]);

            if (current != prev + 1) {
                sb.append(") (").append(current);
            } else {
                sb.append(",").append(current);
            }
            prev = current;
        }
        sb.append(")");
        return sb.toString();
    }


    private static int[] stringLength(String a) {
        String[] values = a.split("");
        Arrays.stream(values)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .forEach((key, value) -> System.out.println(" value: " + value + "| key:" + key));
        return Arrays.stream(values).map(String::length).mapToInt(Integer::intValue).toArray();


    }

    public static int[] method(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int value = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }

            if (k <= map.get(nums[i])) {
                value = nums[i];
            }
        }

        int[] mass = new int[nums.length - map.get(nums[value])];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != value && count < mass.length) {
                mass[count] = nums[j];
                count++;
            }
        }
        return mass;
    }

    public static int[] method1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : nums) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() < k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] deleteDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : nums) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        List<Integer> values = new ArrayList<>();
        for (int value : nums) {
            if (map.get(value) < k) {
                values.add(value);
            }
        }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] removeDuplicates(int[] nums, int k) {

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() < k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] removeDuplicates1(int[] nums, int k) {

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() < k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public String[] deleteElement(String[] str, String value) {
        String[] arr = new String[str.length];
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals(value)) {
                arr[++index] = str[i];
            }
        }
        return arr;
    }
}
