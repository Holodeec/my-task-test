package Task;

import java.util.HashMap;
import java.util.TreeMap;

public class Converter {

    public static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int length = s.length() -1;
        char[] arr = s.toCharArray();
        int a = map.get(arr[length]);
        int mass = 0;

        for (int i = length -1; i >= 0; i--) {
                mass = map.get(arr[i]);

                if (mass < map.get(arr[i+1])) {
                    a -= mass;
                } else {
                    a += mass;
                }
            }
        return a;
    }
}
