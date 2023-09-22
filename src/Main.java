import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws MyException {



    }

    public static String groupNumbers1(String input) {
        String[] values = input.split(",");
        StringBuilder build = new StringBuilder();
        int prev = Integer.parseInt(values[0]);

        build.append("(").append(prev);

        for (int i = 1; i < values.length; i++) {
            int x = Integer.parseInt(values[i]);

            if(x != prev +1) {

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
}