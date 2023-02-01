public class Prob83 {

    public class ListNode {


        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        deleteNode(head);

        return head;
    }

    private static void deleteNode(ListNode node) {
        while (node != null && node.next != null) {
            int val = node.val; // 현재 노드 값 저장
            while (node != null && node.next != null && val == node.next.val) {
                ListNode temp2 = node.next.next;
                node.next = temp2;
            }
            node = node.next;
        }

    }
}