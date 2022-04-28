/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }

        ListNode curr = head;
        ListNode prev = head;
        ListNode prevPrev = null;
        int count = 1;
        while (curr != null && count <= n) {
            curr = curr.next;
            count++;
        }
        if (curr == null && count < n) {
            return null;
        }
        while (curr != null) {
            prevPrev = prev;
            prev = prev.next;
            curr = curr.next;
        }
        if(prevPrev == null){
            head = head.next;
            return head;
        }
        if (prev.next == null) {
            prevPrev.next = null;
        } else {
            prevPrev.next = prev.next;
        }


        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode newNode = removeNthFromEnd(node1, 2);
        while (newNode!=null){
            System.out.println(newNode.val);
            newNode=newNode.next;
        }
    }
}
