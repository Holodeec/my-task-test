package Task;

import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
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


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Создаем фиктивный узел для начала результата
        ListNode curr = dummy;
        int carry = 0; // Переменная для переноса

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0; // Получаем значение текущего узла l1 (если l1 не равен null)
            int y = (l2 != null) ? l2.val : 0; // Получаем значение текущего узла l2 (если l2 не равен null)

            int sum = carry + x + y; // Суммируем значения и перенос

            carry = sum / 10; // Вычисляем перенос для следующего разряда
            curr.next = new ListNode(sum % 10); // Создаем новый узел с текущей цифрой суммы
            curr = curr.next; // Переходим к следующему узлу

            if (l1 != null) {
                l1 = l1.next; // Переходим к следующему узлу списка l1
            }
            if (l2 != null) {
                l2 = l2.next; // Переходим к следующему узлу списка l2
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry); // Если есть оставшийся перенос, создаем новый узел с этим значением
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        var a1 = new ListNode(1,new ListNode(2, new ListNode(3)));
        var a2 = new ListNode(3,new ListNode(2, new ListNode(1)));
        var test = addTwoNumbers(a1,a2);

        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }



}

