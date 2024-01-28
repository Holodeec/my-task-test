import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class Application {
    public static void main(String[] args) {

        var map = Map.of(
                50, 100,
                100, 100,
                500, 50,
                1000,500,
                5000,3);
        Bankomat bankomat = new Bankomat(map);

        System.out.println(bankomat.getMoney(1250));
        String tes1 = "rat", tes2 = "cat";
        String tes3 = "anagram", tes4 = "nagaram";
        System.out.println(isAnagram(tes1, tes2));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        var a = s.toCharArray();
        var b = t.toCharArray();
        sort(a);
        sort(b);

        for (int i =0 ; i< a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    // 1,2,3,4,5,6,7,8,9,10  7
    // 6
    //nums[nums.length /2] > target ? 0 : nums.length /2

}

class Bankomat {


    private Map<Integer, Integer> sum;

    public Bankomat(Map<Integer, Integer> sum) {
        this.sum = sum;
    }

    public Map<Integer, Integer> getMoney(int money) {
        //50₽, 100₽, 500₽, 1000₽, 5000₽
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] arr = sum.keySet().stream().sorted().mapToInt(Integer::intValue).toArray();

        int count = 0;
        for (int i = arr.length -1; i >= 0; i--) {
            if (money == 0) break;

            if (money - arr[i] >= 0) {

                while (money - arr[i] >= 0 && count <= sum.get(arr[i])) {
                    money = money - arr[i];
                    map.put(arr[i], ++count);
                }
                count = 0;
            }

        }
        if (money != 0) throw new RuntimeException("_____________Not have money_____________");
        return map;
    }
}