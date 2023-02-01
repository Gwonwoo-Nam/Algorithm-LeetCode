
import java.util.ArrayList;
import java.util.List;

public class Prob141 {

    public static boolean hasCycle(ListNode head) {

        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next; //느린 포인터는 1칸씩
            fastPtr = fastPtr.next.next; //빠른 포인터는 2칸씩
            if (slowPtr.equals(fastPtr)) { //두 포인터가 만나면?
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode c = new ListNode(0);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(3, b);
        ListNode d = new ListNode(-4, b);
        c.next = d;
        System.out.println(hasCycle(a));
    }
}
