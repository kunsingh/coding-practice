/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkedList2 {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null){
            return null;
        }

        ListNode curr = head;
        ListNode pre = null;

        int noOfNodeToReverse = n-m+1;

        while (m > 1){
            pre = curr;
            curr = curr.next;
            m--;
        }
        ListNode connection = pre;
        ListNode tail = curr;


        while (noOfNodeToReverse > 0){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            noOfNodeToReverse--;
        }

        if(connection != null){
            connection.next = pre;
        }else {
            head = pre;
        }
        tail.next = curr;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;

        ListNode node = reverseBetween(node1, 2, 4);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
