package Task;

import java.util.*;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left) {
        this.value = value;
        this.left = left;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isEmpty() {
        return value == 0 && right == null && left == null;
    }

    @Override
    public String toString() {
        return "val = " + value;
    }

    // todo Метод делает обратный обход бинарного дерева

    public static List<Integer> revers(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode t = stack.pop();
            list.add(t.value);

            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }
        return list;
    }
    // todo Рекурсивный обход дерева

    public static void reversTwin(TreeNode t) {
        reversRecursion(t);
    }

    private static void reversRecursion(TreeNode t) {
        if (t != null) {
            reversRecursion(t.left);
            System.out.println("node = " + t.value);
            reversRecursion(t.right);
        }
    }
    // todo Метод обходит дерево слева на право и считает сумму

    public static int sumDeep(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;

        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            sum += t.value;
            System.out.println(t);


            if (t.right != null) {
                stack.push(t.right);
            }

            if (t.left != null) {
                stack.push(t.left);
            }

        }
        return sum;
    }
    // todo Метод разворачивает бинарное дерево

    public static void reverseInOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }

            current = stack.peek();

            if (current.left != null && current.left != prev) {
                current = current.left;
            } else {
                stack.pop();
                // Выводим элементы в обратном порядке
                System.out.println(current.value);
                prev = current;
                current = null; // что бы не запускался цикл наверху
            }
        }
    }
    // todo Метод обходит бинарное дерево и находит путь с максимальным значением суммируя их

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxPathSum(root.left);
        int maxRight = maxPathSum(root.right);

        return Math.max(maxLeft, maxRight) + root.value;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return new TreeNode(root.value, invertTree(root.right), invertTree(root.left));
    }

    public static void printInOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {

        var tree = new TreeNode(4,

                new TreeNode(2,
                        new TreeNode(1), new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6), new TreeNode(9)));

        printInOrder(invertTree(tree));

    }
}
