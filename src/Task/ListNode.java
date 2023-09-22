package Task;

import java.util.Stack;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return
                "Value = " + val;
    }

    // todo Метод делает обход списка из середины
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return head;
    }

    // todo проверка на палиндром +
    public static boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode last = head;
        Stack<ListNode> stack = new Stack<>();

        while (first != null && first.next != null) {
            stack.push(last);
            last = last.next;
            first = first.next.next;
        }
        if (first != null) {
            last = last.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            if (last.val != stack.pop().val) {
                return false;
            }
            last = last.next;
        }
        return true;
    }



    //todo Метод объединяет два отсортированных массива в 1 отсортированный
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }



}

