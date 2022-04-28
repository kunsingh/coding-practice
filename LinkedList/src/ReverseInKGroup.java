public class ReverseInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head != null) {
            if (head.next == null) {
                return head;
            }
            ListNode curr = head;
            ListNode newHead = curr.next;
            ListNode temp = null;
                while (true) {//1->2->3->4
//                    if (isKNodeAvailable(curr)) {
                        ListNode next = curr.next;
                        temp = next.next;
                        next.next = curr;

                        if (temp == null || temp.next == null) {
                            curr.next = temp;
                            break;
                        }
                        curr.next = temp.next;
                        curr = temp;
                    }

//                }
            return newHead;
        }
        return null;
    }

    public static boolean isKNodeAvailable(ListNode node) {
        ListNode curr = node;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
            if (count == 2) {
                break;
            }
        }

        return count == 2;
    }

    public static boolean isKNodeAvailable(ListNode node, int k) {
        ListNode curr = node;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
            if (count == k) {
                break;
            }
        }

        return count == k;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        ListNode node = reverseKGroup(node1, 4);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
