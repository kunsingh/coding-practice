public class ReverseInPair {

    public static ListNode swapPairs(ListNode head) {
        if(head != null){
            ListNode curr = head;
            ListNode newHead = curr.next;
            while(true){//1->2->3->4
                ListNode next = curr.next;
                ListNode temp = next.next;
                next.next = curr;

                if(temp == null || temp.next == null) {
                    curr.next = null;
                    break;
                }
                curr.next = temp.next;
                curr=temp;
            }
            return newHead;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node = swapPairs(node1);

        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }

    }
}
