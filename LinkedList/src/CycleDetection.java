public class CycleDetection {

    public static boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            if(curr.next == prev){
                return true;
            }else{
                prev = prev.next;
                if(curr.next != null){
                    curr = curr.next.next;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
//        node2.next = node1;

        System.out.println(hasCycle(node1));
    }
}
