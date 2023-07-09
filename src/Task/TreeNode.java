package Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int value;
    List<String> list;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, List<String> list) {
        this.value = value;
        this.list = list;
    }

    public TreeNode(int value, List<String> list, TreeNode left) {
        this.value = value;
        this.list = list;
        this.left = left;
    }

    public TreeNode(int value, List<String> list, TreeNode left, TreeNode right) {
        this.value = value;
        this.list = list;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> revers(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        TreeNode first = treeNode;
        TreeNode last = treeNode;
        Stack<TreeNode> stack = new Stack<>();

        while (first != null || last != null) {
            if (first.left != null) {
                stack.push(first.left);
                stack.push(first);
                stack.push(first.right);
                first = first.left;
            } else if (first.right != null) {
                stack.push(last.left);
                stack.push(last);
                stack.push(last.right);
                last = last.left;
            }
            list.add(stack.pop().value);
        }

        return list;
    }
}
