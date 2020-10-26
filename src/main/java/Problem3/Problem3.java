package Problem3;

import Problem1.LinkedListStack;
import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        list = list.next; //first node is dummy node, so skip
        while (list != null) {
            stack.push(list.val);
            list = list.next;
        }
        while (stack.size() > 0) {
            print.println(stack.pop());
        }
    }
}
