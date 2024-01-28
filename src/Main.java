import Task.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws MyException {

        String s = "CN=Каригов Абди Бесланович,OU=Users,OU=RTI,OU=UF,DC=UF,DC=RT,DC=RU";

        System.out.println(text(s, 3));
    }

    public static String text(String s, int index) {
        Pattern pattern = Pattern.compile("CN=([^\\s]+)\\s([^\\s]+)\\s([^,]+)");
        Matcher matcher = pattern.matcher(s);
        String value = "";
        if (matcher.find()) {
            value = matcher.group(index);
        }
        return value;
    }

    public static boolean construct(String first, String last) {
        char[] chars = first.toCharArray();
        char[] chars1 = last.toCharArray();
        int length = 0, a_index = 0, b_index = 0;

        while (b_index < chars1.length) {
            if (chars[a_index] == chars1[b_index++]) {
                a_index++;
                length++;
            }
            if (length == chars.length) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> revers(TreeNode node) {
        Deque<TreeNode> deque = new ArrayDeque();
        deque.push(node);
        List<Integer> list = new ArrayList<>();
        while (deque.size() > 0) {
            TreeNode tree = deque.pop();
            list.add(tree.value);

            if (tree.left != null) {
                deque.push(tree.left);
            }
            if (tree.right != null) {
                deque.push(tree.right);
            }

        }


        return list;
    }

    public static int maxProfit(int[] prices) {
        int max = Integer.MAX_VALUE;
        int sum = 0;
        int p = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < max) { //7 1 5
                max = prices[i];
            }
            sum = prices[i] - max;
            if (p < sum) {
                p = sum;
            }
        }
        return p;
    }

    public static int[] arr_merge(int[] a, int[] b) {
        int a_size = 0, b_size = 0, index = 0;
        int length1 = a.length, length2 = b.length;

        int[] merged = new int[length1 + length2];

        while (a_size < length1 && b_size < length2) {

            if (a[a_size] < b[b_size]) {
                merged[index++] = a[a_size++];
            } else if (a[a_size] == b[b_size]) {
                merged[index++] = b[b_size++];
            } else {
                merged[index++] = a[a_size++];
                b_size++;
            }

            while (a_size < length1) {
                merged[index++] = a[a_size++];
            }
            while (b_size < length2) {
                merged[index++] = b[b_size++];
            }
        }
        return merged;
    }

    public static boolean isValid(String s) {
        var arr = s.toCharArray();

        if (arr.length % 2 != 0 || arr[0] == '}' || arr[0] == ']' || arr[0] == ')') return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '(') {
                stack.push(')');
            } else if (arr[i] == '{') {
                stack.push('}');
            } else if (arr[i] == '[') {
                stack.push(']');
            } else {
                if (!stack.isEmpty() && stack.peek() == arr[i]) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static int[] method(int[] arr) {

        int value;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 != 0) {

                for (int j = arr.length - 1; j > i; j--) {
                    if (arr[j] % 2 == 0) {
                        value = arr[i];
                        arr[i] = arr[j];
                        arr[j] = value;
                    }

                }

            }
        }
        return arr;
    }


    public static boolean isPalindrome(String s) {
        int length = s.length();
        char[] c = s.replace("[A-Za-z\\W]", "").toLowerCase().toCharArray();
        for (int i = 0; i < (length / 2); i++) {
            if (c[i] != c[length - i - 1]) {
                return false;
            }
        }
        return true;
    }


}